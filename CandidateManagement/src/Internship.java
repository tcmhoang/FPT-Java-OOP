public class Internship extends Candidate {

    private String major;
    private String semester;
    private String university;

    public Internship() {
    }

    public Internship(String majorIn, String term, String colleage,
                      String id, String firstName, String lastName, int birthDate,
                      String address, String phone, String email) {
        super(id, firstName, lastName, birthDate, address, phone, email);
        major = majorIn;
        semester = term;
        university = colleage;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}