package com.gegcuk.todo_list_app.Repository;

import com.gegcuk.todo_list_app.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {

    List<Task> findByDueDateBefore(LocalDateTime dueDate);
}
