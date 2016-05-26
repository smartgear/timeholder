package com.toy.data.extend;

import java.util.List;

import com.toy.model.extend.ParternerExample;
import com.toy.model.generate.Parterner;

public interface ParternerMapper extends com.toy.data.generate.ParternerMapper {
	List<Parterner> selectByExampleWithLimit(ParternerExample example);
}
