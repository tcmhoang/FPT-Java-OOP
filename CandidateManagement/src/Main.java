import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Candidate>> candidateDict = new HashMap<>();
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createCandidate(candidateDict, 0);
                    break;
                case 2:
                    Manager.createCandidate(candidateDict, 1);
                    break;
                case 3:
                    Manager.createCandidate(candidateDict, 2);
                    break;
                case 4:
                    Manager.searchCandidate(candidateDict);
                    break;
                case 5:
                    return;
            }
        }
    }
}