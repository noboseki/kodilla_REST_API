package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTask(final Long aLong) {
        return repository.findById(aLong);
    }

    public Task saveTask(final Task task) {
        repository.save(task);
        return task;
    }

    public boolean deleteTask(final Task task) {
        repository.delete(task);
        return repository.existsById(task.getId());
    }
}
