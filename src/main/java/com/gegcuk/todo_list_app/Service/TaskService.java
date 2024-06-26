package com.gegcuk.todo_list_app.Service;

import com.gegcuk.todo_list_app.Model.Task;
import com.gegcuk.todo_list_app.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, Task task){
        if(taskRepository.existsById(id)) {
            task.setTaskId(id);
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByDueDate(LocalDateTime dueDate){
        return taskRepository.findByDueDateBefore(dueDate);
    }

}
