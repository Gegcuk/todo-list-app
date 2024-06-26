package com.gegcuk.todo_list_app.Controller;

import com.gegcuk.todo_list_app.Model.Task;
import com.gegcuk.todo_list_app.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/tasks")
public class TaskWebController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task_list";
    }

    @GetMapping("/add")
    public String showAddTaskForm(Model model){
        model.addAttribute("task", new Task());
        return "add_task";
    }

    @PostMapping
    public String addTask(@ModelAttribute Task task){
        taskService.createTask(task);
        return "redirect:/tasks";
    }
}
