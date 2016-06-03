package com.toy.service;

import java.util.Date;
import java.util.List;

import com.toy.model.generate.Task;

public interface TaskService {
	/**
	 * @param count
	 * @param page
	 * @return
	 */
	public List<Task> listAllTask(int count, int page, OrderCondition order);	
	
	/**
	 * @param count
	 * @param page
	 * @param status
	 * @return
	 */
	public List<Task> listTaskByStatus(int count, int page, int status, OrderCondition order);	
	
	/**
	 * @param count
	 * @param page
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Task> listTaskByTime(int count, int page, Date begin, Date end, OrderCondition order);
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
