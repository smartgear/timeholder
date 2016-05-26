package com.toy.data.extend;

import java.util.List;

import com.toy.model.generate.User;
import com.toy.model.extend.UserExample;

public interface UserMapper extends com.toy.data.generate.UserMapper{
	List<User> selectByExampleWithLimit(UserExample example);
}