package com.appstude.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.appstude.dao.TaskRepository;
import com.appstude.entities.Task;

@RestController
public class TaskRestController {

	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public List<Task> listTasks(){
		return taskRepository.findAll();
	}
	
	@PostMapping("/tasks")
	public Task save(@RequestBody Task t){
		return taskRepository.save(t);
	}
}
