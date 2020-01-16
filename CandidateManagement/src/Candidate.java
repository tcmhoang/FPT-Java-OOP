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

    public Candidate(String ID, String fstName, String lstName, int birth, String addr, String phoneNumber, String prsEmail) {
        id = ID;
        firstName = fstName;
        lastName = lstName;
        birthDate = birth;
        address = addr;
        phone = phoneNumber;
        email = prsEmail;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return this.firstName + this.lastName + "|" + this.birthDate + "|"
                + this.address + "|" + this.phone + "|" + this.email + "|"
                + this.type;
    }
}