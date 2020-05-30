package be.ucll.ip.tasks.repository;

import be.ucll.ip.tasks.domain.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> taskList;

    public TaskRepository() {
        this.taskList = new ArrayList<>();
        taskList.add(new Task(LocalDateTime.of(2020,3,20,10,0), "Task 1", "Dit is taak 1", 0));
        taskList.add(new Task(LocalDateTime.of(2020,3,21,18,0), "Task 2", "Dit is taak 2", 1));
        taskList.add(new Task(LocalDateTime.of(2020,3,27,17,0), "Task 3", "Dit is taak 3", 2));
    }

    public List<Task> getTasks() {
        return taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void editTask(Task task) {
        taskList.set(task.getId(), task);
    }
}
