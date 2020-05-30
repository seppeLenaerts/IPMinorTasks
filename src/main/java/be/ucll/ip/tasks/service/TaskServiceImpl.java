package be.ucll.ip.tasks.service;

import be.ucll.ip.tasks.domain.Task;
import be.ucll.ip.tasks.dto.TaskDTO;
import be.ucll.ip.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getTasks() {
        return repository.getTasks();
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getDueDate(), taskDTO.getTitle(), taskDTO.getDesc(), taskDTO.getId());
        repository.addTask(task);
    }

    @Override
    public void editTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getDueDate(), taskDTO.getTitle(), taskDTO.getDesc(), taskDTO.getId());
        repository.editTask(task);
    }

    @Override
    public void addSubTask(TaskDTO taskDTO, int id) {
        repository.getTasks().get(id).addSubTask(new Task(null, taskDTO.getTitle(), taskDTO.getDesc(), repository.getTasks().get(id).getSubTasks().size()));
    }
}
