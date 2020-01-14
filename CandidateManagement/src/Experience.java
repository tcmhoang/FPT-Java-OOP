public class Experience extends Candidate {

    private int yearsExperience;
    private String professionalSkills;

    public Experience() {
    }

    public Experience(int years, String skills,
                      String ID, String fstName, String lstName, int birth,
                      String addr, String phone, String email, int type) {
        super(ID, fstName, lstName, birth, addr, phone, email,
                type);
        yearsExperience = years;
        professionalSkills = skills;
    }

    public int getYearExperience() {
        return yearsExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearsExperience = yearExperience;
    }

    public String getProfessionalSkills() {
        return professionalSkills;
    }

    public void setProfessionalSkills(String professionalSkills) {
        this.professionalSkills = professionalSkills;
    }

}