package org.darccona.service;

import org.darccona.database.TaskEntity;
import org.darccona.database.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void create(TaskEntity task) {
        taskRepository.save(task);
    }

    public List<TaskEntity> readAll() {
        return taskRepository.findAll();
    }

    public TaskEntity read(long id) {
        return taskRepository.findById(id);
    }

    public boolean update(long id) {
        TaskEntity task = taskRepository.findById(id);

        if (task != null) {
            task.setFinished(!task.isFinished());
            taskRepository.save(task);
            return true;
        }

        return false;
    }

    public boolean delete(long id) {
        TaskEntity task = taskRepository.findById(id);

        if (task != null) {
            taskRepository.delete(task);
            return true;
        }

        return false;
    }
}
