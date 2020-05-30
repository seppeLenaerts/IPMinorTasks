package be.ucll.ip.tasks.controller;

import be.ucll.ip.tasks.dto.TaskDTO;
import be.ucll.ip.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class TaskController {
	private final TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/error")
	public String getErrorById(Model model){
		model.addAttribute("error", "Task id does not exist");
		return "error";
	}

	@GetMapping("/")
	public String getIndex(Model model){
		return "index";
	}

	@GetMapping("/tasks")
	public String getTasks(Model model){
		model.addAttribute("tasks", taskService.getTasks());
		return "task";
	}

	@GetMapping("/tasks/{id}")
	public String getTaskById(Model model, @PathVariable String id) {
		try {
			model.addAttribute("task", taskService.getTasks().get(Integer.parseInt(id)));
		} catch (Exception e) {
			return getErrorById(model);
		}
		return "taskById";
	}

	@GetMapping("/tasks/edit/{id}")
	public String getTaskEdit(Model model, @PathVariable String id) {
		try {
			model.addAttribute("task", taskService.getTasks().get(Integer.parseInt(id)));
		} catch (Exception e) {
			return getErrorById(model);
		}
		return "taskEdit";
	}

	@GetMapping("/tasks/{id}/sub/create")
	public String getAddSubTask(Model model, @PathVariable String id) {
		try {
			model.addAttribute("task", taskService.getTasks().get(Integer.parseInt(id)));
		} catch (Exception e) {
			return getErrorById(model);
		}
		return "taskCreateSubTask";
	}

	@PostMapping("/tasks/{id}/sub/add")
	public String addSubTask(@ModelAttribute TaskDTO taskDTO, @PathVariable String id){
		taskService.addSubTask(taskDTO, Integer.parseInt(id));
		return "redirect:/tasks/" + id;
	}

	@GetMapping("/tasks/new")
	public String getAddTask() {
		return "taskNew";
	}

	@PostMapping("/tasks/new")
	public String addTask(@ModelAttribute TaskDTO taskDTO, @RequestParam("due") String dueDate){
		taskDTO.setDueDate(LocalDateTime.parse(dueDate));
		taskDTO.setId(taskService.getTasks().size());
		taskService.addTask(taskDTO);
		return "redirect:/tasks";
	}

	@PostMapping("/tasks/edited/{id}")
	public String editTask(@ModelAttribute TaskDTO taskDTO, @RequestParam("due") String dueDate, @PathVariable String id){
		taskDTO.setDueDate(LocalDateTime.parse(dueDate));
		taskDTO.setId(Integer.parseInt(id));
		taskService.editTask(taskDTO);
		return "redirect:/tasks/" + id;
	}
}
