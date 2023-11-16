package br.com.kaio.todolist.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title", nullable = false, unique = true)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "status")
    private boolean status;
}
