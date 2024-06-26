package com.gegcuk.todo_list_app.Controller;

import com.gegcuk.todo_list_app.Model.Task;
import com.gegcuk.todo_list_app.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable("id") Long id, Model model){
        Optional<Task> task = taskService.findTaskById(id);
        if(task.isPresent()){
            model.addAttribute("task", task.get());
            return "edit_task";
        } else {
            return "redirect:/tasks";
        }
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, @ModelAttribute Task task){
        taskService.updateTask(id, task);
        return "redirect:/tasks";
    }

    @PostMapping("/complete/{id}")
    public String completeTask(@PathVariable("id") Long id){
        Optional<Task> taskOptional = taskService.findTaskById(id);
        if(taskOptional.isPresent()){
            Task task = taskOptional.get();
            task.setCompleted(true);
            taskService.updateTask(id, task);
        }
        return "redirect:/tasks";
    }
}
