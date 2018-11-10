package com.appstude.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="TASKS")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	private String taskName;
	
	public Task(){
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Task(Long id, String taskName) {
		super();
		this.id = id;
		this.taskName = taskName;
	}
	
	
	
}
