package com.toy.service;

import java.util.List;

import com.toy.model.generate.Task;

public interface TaskService {
	/**
	 * @param count
	 * @param page
	 * @return
	 */
	public List<Task> listTask(int count, int page);	
	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public int getTaskCount();
	
	/**
	 * @param task
	 * @return
	 */
	public Task addTask(Task task);
	
	/**
	 * @param task
	 * @return
	 */
	public Task updateTask(Task task);
	
	/**
	 * @param title
	 * @return
	 */
	public List<Task> findTaskByTitle(String title);
}
