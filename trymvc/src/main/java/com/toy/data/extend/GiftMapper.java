package com.toy.data.extend;

import java.util.List;

import com.toy.model.extend.GiftExample;
import com.toy.model.generate.Gift;

public interface GiftMapper extends com.toy.data.generate.GiftMapper {
	List<Gift> selectByExampleWithLimit(GiftExample example);
}
