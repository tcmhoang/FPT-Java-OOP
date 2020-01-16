import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static Buffer buffer = new Buffer();
    public static void main(String[] args) {
	// write your code here
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Producer());
        executorService.execute(new Consumer());
        executorService.execute(new Producer());
        executorService.execute(new Consumer());
        executorService.shutdown();


    }
    public static class Producer implements  Runnable{
        @Override
        public void run(){
            try{
                int i = 1;
                while (true){
                    System.out.println("Tries to write..." + i);
                    buffer.write(i++);
                    Thread.sleep((int)(Math.random()*1000));
                }
            } catch (InterruptedException e) {
                System.out.println("Producer tried to write: " + e.getMessage());
            }
        }
    }
    public static class Consumer implements Runnable{
        @Override
        public void run() {
            try{
                while (true){
                    System.out.println("Read " + buffer.read());
                    Thread.sleep((int)(Math.random()*1000));
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer tried to " + e.getMessage());;
            }
        }
    }
}
