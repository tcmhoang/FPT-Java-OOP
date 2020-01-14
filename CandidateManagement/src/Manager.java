import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class Manager {

    public static void init(HashMap<Integer,ArrayList<Candidate>>candidateDict){
        for(int i = 0 ; i < 3; i++){
            candidateDict.put(i, new ArrayList<>());
        }
    }

    public static int menu() {
        System.out.println("1. Experience\n" + "2. Fresher\n" + "3. Internship\n" + "4. Searching\n" + "5. Exit\n"
                + "Enter your choice: ");
        return Validation.checkInputIntLimit(1, 5);
    }

    public static void createCandidate(HashMap<Integer, ArrayList<Candidate>> candidateDict,
                                       int type) {
        /*
         *type:   0=Senior
         *        1=Freshman
         *        2=Interns
         */
        if(candidateDict.get(0) == null){
            init(candidateDict);
        }
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            System.out.print("Enter first name: ");
            String firstName = Validation.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = Validation.checkInputString();
            System.out.print("Enter birth date: ");
            int birthDate = Validation.checkInputIntLimit(1900,
                    Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = Validation.checkInputString();
            System.out.print("Enter phone: ");
            String phone = Validation.checkInputPhone();
            System.out.print("Enter email: ");
            String email = Validation.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName,
                    birthDate, address, phone, email, type);
            //check id exist or not
            if (Validation.checkIdExist(candidateDict, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidateDict, candidate);
                        break;
                    case 1:
                        createFresher(candidateDict, candidate);
                        break;
                    case 2:
                        createInternship(candidateDict, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");
            //check user want to create new candidate or not
            if (!Validation.validateOption()) {
                return;
            }
        }
    }

    //allow user create experience
    public static void createExperience(HashMap<Integer, ArrayList<Candidate>> candidateDict,
                                        Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Validation.checkExperiences(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validation.checkInputString();
        candidateDict.get(0).add(new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.out.println("Create success.");
    }

    //allow user create fresher
    public static void createFresher(HashMap<Integer, ArrayList<Candidate>> candidateDict,
                                     Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = Validation.checkInputString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = Validation.checkInputGraduationRank();
        candidateDict.get(1).add(new Fresher(graduationDate, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.out.println("Create success.");
    }

    //allow user create internship
    public static void createInternship(HashMap<Integer, ArrayList<Candidate>> candidateDict,
                                        Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validation.checkInputString();
        System.out.print("Enter semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Enter university: ");
        String university = Validation.checkInputString();
        candidateDict.get(3).add(new Internship(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.out.println("Create success.");
    }

    //allow user search candidate by name
    public static void searchCandidate(HashMap<Integer, ArrayList<Candidate>> candidateDict) {
        printListNameCandidate(candidateDict);
        System.out.print("Enter candidate name (First name or Last name): ");
        String nameSearch = Validation.checkInputString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = Validation.checkInputIntLimit(0, 2);
        for (Candidate candidate : candidateDict.get(typeCandidate)) {
            if (candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
            }
        }
    }

    //display list name candidate
    public static void printListNameCandidate(HashMap<Integer, ArrayList<Candidate>> candidateDict) {
        System.out.println("***Experience Candidate***");
        for (Candidate candidate : candidateDict.get(0)) {
            System.out.println(candidate.getFirstName() + " "
                    + candidate.getLastName());
        }
        System.out.println("***Fresher Candidate***");
        for (Candidate candidate : candidateDict.get(1)) {
            System.out.println(candidate.getFirstName() + " "
                    + candidate.getLastName());
        }
        System.out.println("***Internship Candidate***");
        for (Candidate candidate : candidateDict.get(2)) {
            System.out.println(candidate.getFirstName() + " "
                    + candidate.getLastName());
        }
    }

}