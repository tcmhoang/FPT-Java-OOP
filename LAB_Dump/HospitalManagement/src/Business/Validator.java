package Business;

import Entity.Doctor;

public class Validator
{
    //check user change information or not
    public static boolean checkChangeInfo(Doctor doctor, String code,
                                          String name, String specialization, int availability)
    {
        return !doctor.getCode().equalsIgnoreCase(code)
                || !doctor.getName().equalsIgnoreCase(name)
                || !doctor.getSpecialization().equalsIgnoreCase(specialization)
                || doctor.getAvailability() != availability;
    }
}
