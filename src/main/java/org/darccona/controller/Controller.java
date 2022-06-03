package org.darccona.controller;

import org.darccona.database.TaskEntity;
import org.darccona.database.TaskRepository;
import org.darccona.model.TaskModel;
import org.darccona.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private TaskRepository task;

    private final TaskService service;

    public Controller(TaskService service) {
        this.service = service;
    }

    @PostMapping(value = "/tasks")
    public ResponseEntity<?> create(@RequestBody TaskModel task) {
        service.create(new TaskEntity(task.getText()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/tasks")
    public ResponseEntity<List<TaskEntity>> read() {
        final List<TaskEntity> tasks = service.readAll();

        return tasks != null &&  !tasks.isEmpty()
                ? new ResponseEntity<>(tasks, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<TaskEntity> read(@PathVariable(name = "id") long id) {
        final TaskEntity task = service.read(id);

        return task != null
                ? new ResponseEntity<>(task, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id) {
        final boolean updated = service.update(id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = service.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
