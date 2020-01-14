public class Candidate {

    private String id;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private String phone;
    private String email;
    private int type;

    public Candidate() {
    }

    public Candidate(String ID, String fstName, String lstName, int birth, String addr, String phoneNumber, String prsEmail, int category) {
        id = ID;
        firstName = fstName;
        lastName = lstName;
        birthDate = birth;
        address = addr;
        phone = phoneNumber;
        email = prsEmail;
        type = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTypeCandidate() {
        return type;
    }

    public void setTypeCandidate(int typeCandidate) {
        this.type = typeCandidate;
    }

    @Override
    public String toString() {
        return this.firstName + this.lastName + "|" + this.birthDate + "|"
                + this.address + "|" + this.phone + "|" + this.email + "|"
                + this.type;
    }
}