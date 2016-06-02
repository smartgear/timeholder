package com.toy.data.extend;

import java.util.List;

import com.toy.model.extend.TaskExample;
import com.toy.model.generate.Task;

public interface TaskMapper extends com.toy.data.generate.TaskMapper {
	List<Task> selectByExampleWithLimit(TaskExample example);
}
