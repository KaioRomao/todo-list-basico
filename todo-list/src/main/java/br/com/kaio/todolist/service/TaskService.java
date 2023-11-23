package br.com.kaio.todolist.service;

import br.com.kaio.todolist.dto.TaskDTO;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Optional<TaskDTO> create(TaskDTO request);

    List<TaskDTO> getAll();
    Optional<TaskDTO> getById(Long id);

    boolean delete(Long id);

    Optional<TaskDTO> update(Long id, TaskDTO request);
}
