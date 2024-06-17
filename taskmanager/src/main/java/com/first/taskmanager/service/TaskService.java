package com.first.taskmanager.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.first.taskmanager.entities.TaskEntity;

@Service	
public class TaskService {
	private ArrayList<TaskEntity> tasks = new ArrayList<>();
	private int taskId = 1;
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
	
	public TaskEntity addTask(String title, String description, String deadline) throws ParseException{
		TaskEntity task = new TaskEntity();
		task.setId(taskId);
		task.setTitle(title);
		task.setDescription(description);
	    task.setDeadline(dateFormat.parse(deadline)); //Validates Date Format YYYY-MM-DD
		task.setCompleted(false);
		tasks.add(task);
		taskId++;
		return task;
	}
	
	public ArrayList<TaskEntity> getTasks(){
		return tasks;
	}
	
	public TaskEntity getTaskById (int id) {
		for(TaskEntity task : tasks) {
			if(task.getId() == id)
				return task;
		}
		return null;
		//return tasks.stream().findAny().filter(task -> task.getId() == id).orElse(null);
	}
	
	public TaskEntity updateTask(int id, String title, String description, String deadline, boolean completed) throws ParseException{
		TaskEntity task = getTaskById(id);
		if(task == null) return null;
		
		if(title != null) task.setTitle(title);
		if(description != null) task.setDescription(description);
		if(deadline != null) task.setDeadline(dateFormat.parse(deadline));
		if(task.isCompleted() != completed) task.setCompleted(completed);
		
		return task;
	}
}
