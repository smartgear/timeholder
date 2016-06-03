package com.toy.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.toy.data.extend.TaskMapper;
import com.toy.data.generate.IdSequenceMapper;
import com.toy.model.extend.Limit;
import com.toy.model.extend.TaskExample;
import com.toy.model.generate.IdSequence;
import com.toy.model.generate.Task;
import com.toy.service.OrderCondition;
import com.toy.service.TaskService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
	private IdSequenceMapper idSequenceMapper;
	public IdSequenceMapper getIdSequenceMapper() {
		return idSequenceMapper;
	}

	@Resource
	public void setIdSequenceMapper(IdSequenceMapper idSequenceMapper) {
		this.idSequenceMapper = idSequenceMapper;
	}

	private TaskMapper taskMapper;


	public TaskMapper getTaskMapper() {
		return taskMapper;
	}

	@Resource
	public void setTaskMapper(TaskMapper taskMapper) {
		this.taskMapper = taskMapper;
	}

	public List<Task> listTask(int count, int page) {
		Limit limit = new Limit();
		limit.setOffset(count*(page-1));
		limit.setRowcount(count);
		TaskExample example = new TaskExample();
		example.setLimitClause(limit);
		List<Task> result =  taskMapper.selectByExampleWithLimit(example);
		return result;
	}

	public int getTaskCount() {
		return taskMapper.countByExample(null);
	}

	public Task addTask(Task task) {
		IdSequence id = new IdSequence();
		idSequenceMapper.insert(id);
		String taskID = "task"+id.getId();
		task.setId(taskID);
		task.setCreatetime(new Date());
		taskMapper.insert(task);
		return task;
	}

	public Task updateTask(Task task) {
		taskMapper.updateByPrimaryKey(task);
		return task;
	}

	public List<Task> findTaskByTitle(String title) {
		TaskExample example = new TaskExample();
		example.createCriteria().andTitleLike("%"+title+"%");
		List<Task> result = taskMapper.selectByExample(example);
		return result;
	}

	public List<Task> listAllTask(int count, int page, OrderCondition order) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Task> listTaskByStatus(int count, int page, int status, OrderCondition order) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Task> listTaskByTime(int count, int page, Date begin, Date end, OrderCondition order) {
		// TODO Auto-generated method stub
		return null;
	}

}
