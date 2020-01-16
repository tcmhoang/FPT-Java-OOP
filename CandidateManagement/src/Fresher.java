public class Fresher extends Candidate {

    private String graduationDate;
    private String graduationRank;

    public Fresher() {
    }

    public Fresher(String date, String rank, String id,
                   String fstName, String lstName, int birthDate, String address,
                   String phone, String email) {
        super(id, fstName, lstName, birthDate, address, phone, email);
        graduationDate = date;
        graduationRank = rank;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

}