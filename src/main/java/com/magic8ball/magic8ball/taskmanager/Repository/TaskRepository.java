package com.magic8ball.magic8ball.taskmanager.Repository;

import com.magic8ball.magic8ball.taskmanager.Entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
}
