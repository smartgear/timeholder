package com.toy.service.impl;

import java.util.ArrayList;
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
import com.toy.model.generate.User;
import com.toy.service.InvalidTokenException;
import com.toy.service.NoPermissionException;
import com.toy.service.OrderCondition;
import com.toy.service.TaskService;
import com.toy.service.TaskState;
import com.toy.service.UserService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
	private IdSequenceMapper idSequenceMapper;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

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

	public List<Task> listTask(int count, int page, String utoken) {
		List<Task> result = new ArrayList<Task>();
		User user = userService.getUserWithToken(utoken);
		if(user==null) return result;
		Limit limit = new Limit();
		limit.setOffset(count*(page-1));
		limit.setRowcount(count);
		TaskExample example = new TaskExample();
		example.createCriteria().andUserIdEqualTo(user.getUserId());
		example.setLimitClause(limit);
		result =  taskMapper.selectByExampleWithLimit(example);
		return result;
	}

	public int getTaskCount(String utoken) {
		User user = userService.getUserWithToken(utoken);
		if(user==null) return 0;
		TaskExample example = new TaskExample();
		example.createCriteria().andUserIdEqualTo(user.getUserId());
		return taskMapper.countByExample(example);
	}

	public Task addTask(Task task, String utoken) throws InvalidTokenException{
		User user = userService.getUserWithToken(utoken);
		if(user==null) throw new InvalidTokenException("user not login.");
		IdSequence id = new IdSequence();
		idSequenceMapper.insert(id);
		String taskID = "task"+id.getId();
		task.setId(taskID);
		task.setCreatetime(new Date());
		task.setUserId(user.getUserId());
		taskMapper.insert(task);
		return task;
	}

	public Task updateTask(Task task, String utoken) {
		User user = userService.getUserWithToken(utoken);
		if(user==null) throw new InvalidTokenException("user not login.");
		Task originalTask = taskMapper.selectByPrimaryKey(task.getId());
		originalTask.setDetail(task.getDetail());
		originalTask.setDuedate(task.getDuedate());
		originalTask.setImportance(task.getImportance());
		originalTask.setPriority(task.getPriority());
		if(!originalTask.getState().equals(task.getState())){
			originalTask.setState(task.getState());
			if(originalTask.getState().equals(TaskState.finished.ordinal())){
				originalTask.setClosetime(new Date());
			}
		}
		originalTask.setDuedate(task.getDuedate());
		originalTask.setTitle(task.getTitle());
		taskMapper.updateByPrimaryKey(originalTask);
		return originalTask;
	}

	public List<Task> findTaskByTitle(String title, String utoken) {
		User user = userService.getUserWithToken(utoken);
		if(user==null) throw new InvalidTokenException("user not login.");
		TaskExample example = new TaskExample();
		example.createCriteria().andUserIdEqualTo(user.getUserId()).andTitleLike("%"+title+"%");
		List<Task> result = taskMapper.selectByExample(example);
		return result;
	}

	public List<Task> listAllTask(int count, int page, OrderCondition order, String utoken) {
		User user = userService.getUserWithToken(utoken);
		if(user==null) throw new InvalidTokenException("user not login.");
		TaskExample example = new TaskExample();
		example.createCriteria().andUserIdEqualTo(user.getUserId());
		Limit limit = new Limit();
		limit.setOffset(count*(page-1));
		limit.setRowcount(count);
		example.setLimitClause(limit);
		example.setOrderByClause(order.toString());		
		List<Task> result = taskMapper.selectByExample(example);
		return result;
	}

	public List<Task> listTaskByStatus(int count, int page, int status, OrderCondition order, String utoken) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Task> listTaskByTime(int count, int page, Date begin, Date end, OrderCondition order, String utoken) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean checkPrivilege(Task task, User user ) throws NoPermissionException{
		if(!task.getUserId().equals(user.getUserId())) throw new NoPermissionException("no permission to update this task");
		return true;
	}

}
