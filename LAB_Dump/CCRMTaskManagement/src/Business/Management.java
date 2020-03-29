package Business;

import Entity.Task;

import java.util.ArrayList;
import java.util.List;

public class Management
{
    List<Task> tasks;
    int count;

    public Management()
    {
        tasks = new ArrayList<>();
        count = 0;
    }

    public void addTask(Task task)
    {
        tasks.add(task);
        count++;
    }

    public int getID()
    {
        return count;
    }

    public List<Task> getTasks()
    {
        return tasks;
    }

    public boolean deleteTask(Task task)
    {
        if (task != null)
        {
            int idx = tasks.indexOf(task);
            if (idx == -1)
                return false;
            tasks.remove(task);
            return true;
        }
        return false;
    }

    public Task findTaskExist(int id)
    {
        return tasks.stream().filter(k -> k.getId() == id).findFirst().orElse(null);
    }
}
