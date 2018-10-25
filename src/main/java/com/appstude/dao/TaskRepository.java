package com.appstude.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appstude.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
