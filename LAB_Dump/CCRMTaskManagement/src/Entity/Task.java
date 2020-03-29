package Entity;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task
{
    private int id;
    private String taskTypeId;
    private String requirementName;
    private Date date;
    private String planFrom;
    private String planTo;
    private String assign;
    private String reviewer;

    public Task()
    {
    }

    public Task(int id, String taskTypeId, String requirementName, Date date, String planFrom, String planTo, String assign, String reviewer)
    {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public String getTaskTypeId()
    {
        return taskTypeId;
    }

    public String getRequirementName()
    {
        return requirementName;
    }

    public String getPlanFrom()
    {
        return planFrom;
    }

    public String getPlanTo()
    {
        return planTo;
    }

    public String getAssign()
    {
        return assign;
    }

    public String getReviewer()
    {
        return reviewer;
    }

    @Override
    public String toString()
    {
        return MessageFormat.format("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                id,
                requirementName,
                taskTypeId,
                new SimpleDateFormat("dd-MM-yyyy").format(date),
                Double.parseDouble(planTo) - Double.parseDouble(planFrom),
                assign,
                reviewer);
    }
}