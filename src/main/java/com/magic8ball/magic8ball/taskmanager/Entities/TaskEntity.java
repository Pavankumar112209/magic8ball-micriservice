package com.magic8ball.magic8ball.taskmanager.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="TaskName",nullable = false)
    private String TaskName;

    @Column(name = "Description",nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;
}
