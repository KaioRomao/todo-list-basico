package br.com.kaio.todolist.service;


import br.com.kaio.todolist.dto.TaskDTO;
import br.com.kaio.todolist.model.Task;
import br.com.kaio.todolist.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Optional<TaskDTO> create(TaskDTO request) {

        Task task = modelMapper.map(request, Task.class);
        repository.saveAndFlush(task);

        TaskDTO response = modelMapper.map(task, TaskDTO.class);
        String statusDescription = task.isStatus() ? "Concluído" : "Não Concluído";
        response.setStatusDescription(statusDescription);

        return Optional.of(response);
    }

    @Override
    public List<TaskDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(task -> {
                    TaskDTO response = modelMapper.map(task, TaskDTO.class);
                    String statusDescription = task.isStatus() ? "Concluído" : "Não Concluído";
                    response.setStatusDescription(statusDescription);

                    return response;
                }).collect(Collectors.toList());
    }


}
