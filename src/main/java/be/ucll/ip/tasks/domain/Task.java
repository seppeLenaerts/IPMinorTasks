package be.ucll.ip.tasks.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private LocalDateTime dueDate;
    private String title;
    private String description;
    private int id;
    private List<Task> subTasks;

    public Task(LocalDateTime dueDate, String title, String description, int id) {
        this.dueDate = dueDate;
        this.title = title;
        this.description = description;
        this.id = id;
        this.subTasks = new ArrayList<>();
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getTitle() + ": due " + getDueDateString();
    }

    public String getDueDateString() {
        return getDueDate().getMonth().name() + " " + getDueDate().getDayOfMonth() + " " + getDueDate().getYear() + " at " + getDueDate().getHour() + "h";
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void addSubTask(Task task) {
        subTasks.add(task);
    }
}
