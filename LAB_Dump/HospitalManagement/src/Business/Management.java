package Business;

import Entity.Doctor;

import java.util.ArrayList;
import java.util.List;

public class Management
{
    List<Doctor> data;

    public Management()
    {
        data = new ArrayList<>();
    }

    public void add(Doctor temp)
    {
        data.add(temp);
    }

    //check code exist or not
    public boolean isCodeExist(String code)
    {
        //check from first to last list doctor
        for (Doctor doctor : data)
        {
            if (code.equalsIgnoreCase(doctor.getCode()))
            {
                return true;
            }
        }
        return false;
    }

    //check doctor duplicate
    public boolean isDuplicate(Doctor d)
    {
        String code = d.getCode(),
                name = d.getName(),
                specs = d.getSpecialization();
        int avail = d.getAvailability();
        //check from first to last list doctor
        for (Doctor doctor : data)
        {
            if (code.equalsIgnoreCase(doctor.getCode())
                    && name.equalsIgnoreCase(doctor.getName())
                    && specs.equalsIgnoreCase(doctor.getSpecialization())
                    && avail == doctor.getAvailability())
                return true;
        }
        return false;
    }


    //get doctor by code
    public Doctor getDocByID(String code)
    {
        for (Doctor doctor : data)
        {
            if (doctor.getCode().equalsIgnoreCase(code))
                return doctor;
        }
        return null;
    }

    //allow user delete doctor
    public boolean delDoc(Doctor doctor)
    {
        if (doctor == null)
            return false;
        data.remove(doctor);
        return true;
    }

    //get list found by name
    public List<Doctor> getDocsByName(String name)
    {
        List<Doctor> res = new ArrayList<>();
        for (Doctor doctor : data)
        {
            if (doctor.getName().contains(name))
            {
                res.add(doctor);
            }
        }
        return res;
    }


}
