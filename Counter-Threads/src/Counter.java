import java.util.Arrays;
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
//        Enter arrays of number use as data bundle
        int output = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of all the number you wanna use to sum: ");
        int[] data = new int[(input.nextInt())];
        for (int i = 0; i < data.length; i++) {
            System.out.print("Number " + i + " : ");
            data[i] = input.nextInt();
        }
        // Enter threads to analyze
        System.out.println("How many threads you wanna use?");
        int threads = input.nextInt();
        AdorableThread[] totThreads = new AdorableThread[threads];
        for (int num : data) {
            int[] workLoads = allocateWork(num,threads);
            for(int i = 0 ; i < totThreads.length ; i ++){
                totThreads[i] = new AdorableThread(getIndividualWork(workLoads,i));
            }
            for (AdorableThread thread : totThreads) {
                thread.start();
            }
            try {
                for (AdorableThread thread : totThreads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                //ignore
            }
            for (AdorableThread thread : totThreads) {
                output += thread.getRes();
            }
            System.out.println(output + num);
            output = 0;
        }
    }

    public static int[] allocateWork(int number, int size) {
        int avgWorks = number / size;
        int[] workloads = new int[size];
        int before = 0;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                workloads[i] = number;
            } else {
                workloads[i] = avgWorks + before;
                before = workloads[i];
            }
        }
        return workloads;
    }

    public static int[] getIndividualWork(int[] workTable, int threadID) {
        int[] output = new int[2];
        if (threadID == 0) {
            output[1] = workTable[0];
        } else {
            output[0] = workTable[threadID - 1];
            output[1] = workTable[threadID];
        }
        return output;
    }

}
