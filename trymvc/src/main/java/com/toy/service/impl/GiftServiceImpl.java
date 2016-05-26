package com.toy.service.impl;

import java.util.Date;
import java.util.List;

import com.toy.data.extend.GiftMapper;
import com.toy.data.generate.IdSequenceMapper;
import com.toy.model.extend.GiftExample;
import com.toy.model.extend.Limit;
import com.toy.model.generate.Gift;
import com.toy.model.generate.IdSequence;
import com.toy.service.GiftService;
import com.toy.service.ToyException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("giftService")
public class GiftServiceImpl implements GiftService {
	private IdSequenceMapper idSequenceMapper;
	private GiftMapper giftMapper;

	public IdSequenceMapper getIdSequenceMapper() {
		return idSequenceMapper;
	}

	@Resource
	public void setIdSequenceMapper(IdSequenceMapper idSequenceMapper) {
		this.idSequenceMapper = idSequenceMapper;
	}

	
	public GiftMapper getGiftMapper() {
		return giftMapper;
	}

	@Resource
	public void setGiftMapper(GiftMapper giftMapper) {
		this.giftMapper = giftMapper;
	}

	public int getGiftCount() throws ToyException {
		int result = giftMapper.countByExample(null);
		return result;
	}

	public Gift getGiftByID(String id) throws ToyException {
		Gift result =  giftMapper.selectByPrimaryKey(id);
		return result;
	}

	public List<Gift> findGiftByName(String name) throws ToyException {
		GiftExample example = new GiftExample();
		example.createCriteria().andNameLike("%"+name+"%");
		List<Gift> result = giftMapper.selectByExample(example);
		return result;
	}

	public List<Gift> listGifts(int count, int page) throws ToyException {
		Limit limit = new Limit();
		limit.setOffset(count*(page-1));
		limit.setRowcount(count);
		GiftExample example = new GiftExample();
		example.setLimitClause(limit);
		List<Gift> result =  giftMapper.selectByExampleWithLimit(example);
		return result;
	}

	public Gift updateGift(Gift gift) throws ToyException {
		giftMapper.updateByPrimaryKey(gift);
		return gift;
	}

	public Gift addGift(Gift gift) throws ToyException {
		IdSequence id = new IdSequence();
		idSequenceMapper.insert(id);
		String giftID = "gf"+id.getId();
		gift.setId(giftID);
		gift.setCreateTime(new Date());
		giftMapper.insert(gift);
		return gift;
	}
}
