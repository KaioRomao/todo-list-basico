package br.com.kaio.todolist.controller;

import br.com.kaio.todolist.dto.TaskDTO;
import br.com.kaio.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO request) {
        Optional<TaskDTO> response = service.create(request);
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
