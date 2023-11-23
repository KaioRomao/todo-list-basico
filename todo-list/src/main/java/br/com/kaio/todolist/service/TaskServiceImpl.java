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

    private void formatStatus(Task task, TaskDTO response){
        String statusDescription = task.isStatus() ? "Concluído" : "Não Concluído";
        response.setStatusDescription(statusDescription);
    }

    @Override
    public Optional<TaskDTO> create(TaskDTO request) {

        Task task = modelMapper.map(request, Task.class);
        repository.saveAndFlush(task);

        TaskDTO response = modelMapper.map(task, TaskDTO.class);
        formatStatus(task, response);

        return Optional.of(response);
    }

    @Override
    public List<TaskDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(task -> {
                    TaskDTO response = modelMapper.map(task, TaskDTO.class);
                    formatStatus(task, response);

                    return response;
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<TaskDTO> getById(Long id) {
        Optional<Task> task = repository.findById(id);
        if(task.isPresent()){
           TaskDTO response =  modelMapper.map(task.get(), TaskDTO.class);
            formatStatus(task.get(), response);
            return Optional.of(response);
        }

        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Task> task = repository.findById(id);
        if(task.isPresent()){
            repository.delete(task.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<TaskDTO> update(Long id, TaskDTO request) {
        Optional<Task> task = repository.findById(id);
        if(task.isPresent()){
            Task taskAtt = task.get();
            taskAtt.setTitle(request.getTitle());
            taskAtt.setDescription(request.getDescription());
            taskAtt.setStatus(request.isStatus());
            repository.saveAndFlush(taskAtt);

            TaskDTO response = modelMapper.map(taskAtt, TaskDTO.class);
            formatStatus(taskAtt, response);

            return Optional.of(response);
        }
        else {
            return Optional.empty();
        }
    }


}
