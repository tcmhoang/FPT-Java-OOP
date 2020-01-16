import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private static final int CAPACITY = 10;
    private LinkedList<Integer> queue = new LinkedList<>();
    private static Lock spinLock = new ReentrantLock(); // using it in critical session
    private static Condition notEmpty = spinLock.newCondition();//same as semaphore control n queue holding 0
    private static Condition notFull = spinLock.newCondition();//same as semaphore control n queue holding n

    public void write(int value) {
        spinLock.lock();
        try {
            while (queue.size() == CAPACITY) {
                System.out.println("Wait for spaces to write ..." + value);
                notFull.await();
            }
            queue.offer((value));
            notEmpty.signal();
        } catch (InterruptedException e) {
            System.out.println("Buffer was being written caught err ... " + e.getMessage());
        } finally {
            spinLock.unlock();
        }
    }

    public int read() {
        int value = 0;
        spinLock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Waiting a value to read ...");
                notEmpty.await();
            }
            value = queue.remove();//like popfirst()! in julia
        } catch (InterruptedException e) {
            System.out.println("Buffer was being read caught err ..." + e.getMessage());
        } finally {
            spinLock.lock();
        }
        return value;
    }

}

