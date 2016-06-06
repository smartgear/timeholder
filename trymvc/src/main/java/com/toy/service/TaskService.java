package com.toy.service;

import java.util.Date;
import java.util.List;

import com.toy.model.generate.Task;

public interface TaskService {
	/**
	 * @param count
	 * @param page
	 * @param order
	 * @param utoken
	 * @return
	 */
	public List<Task> listAllTask(int count, int page, OrderCondition order, String utoken);	
	
	/**
	 * @param count
	 * @param page
	 * @param status
	 * @return
	 */
	public List<Task> listTaskByStatus(int count, int page, int status, OrderCondition order, String utoken);	
	
	/**
	 * @param count
	 * @param page
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Task> listTaskByTime(int count, int page, Date begin, Date end, OrderCondition order, String utoken);
	/**
	 * @return
	 */
	public int getTaskCount(String utoken);	
	/**
	 * @param task
	 * @return
	 */
	public Task addTask(Task task, String utoken);
	
	/**
	 * @param task
	 * @return
	 */
	public Task updateTask(Task task, String utoken);
	
	/**
	 * @param title
	 * @return
	 */
	public List<Task> findTaskByTitle(String title, String utoken);
}
