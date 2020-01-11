public class AdorableThread extends Thread {
    private int start, end, output;
    AdorableThread(int[] countTable){
        start = countTable[0];
        end = countTable[1];
        output = 0;
    }
    public void run(){
        for(int i = start; i < end; i++){
            output += i;
        }
    }
    int getRes(){
        return output;
    }
}
