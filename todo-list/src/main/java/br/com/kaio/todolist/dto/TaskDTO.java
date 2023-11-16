package br.com.kaio.todolist.dto;

import lombok.Data;

@Data
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private boolean status;
    private String statusDescription;
}
