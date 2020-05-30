package be.ucll.ip.tasks.service;


import be.ucll.ip.tasks.domain.Task;
import be.ucll.ip.tasks.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    void addTask(TaskDTO taskDTO);
    void editTask(TaskDTO taskDTO);
    void addSubTask(TaskDTO taskDTO, int id);
}
