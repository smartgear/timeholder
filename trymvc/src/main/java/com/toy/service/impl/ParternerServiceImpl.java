package com.toy.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.toy.data.extend.ParternerMapper;
import com.toy.data.generate.IdSequenceMapper;
import com.toy.model.extend.Limit;
import com.toy.model.extend.ParternerExample;
import com.toy.model.generate.IdSequence;
import com.toy.model.generate.Parterner;
import com.toy.service.ParternerService;
import com.toy.service.ToyException;

@Service("parternerService")
public class ParternerServiceImpl implements ParternerService {

	private ParternerMapper parternerMapper;
	private IdSequenceMapper idSequenceMapper;

	public ParternerMapper getParternerMapper() {
		return parternerMapper;
	}

	@Resource
	public void setParternerMapper(ParternerMapper parternerMapper) {
		this.parternerMapper = parternerMapper;
	}

	public IdSequenceMapper getIdSequenceMapper() {
		return idSequenceMapper;
	}

	@Resource
	public void setIdSequenceMapper(IdSequenceMapper idSequenceMapper) {
		this.idSequenceMapper = idSequenceMapper;
	}

	public Parterner addParter(Parterner parterner) throws ToyException {
		IdSequence idSequence = new IdSequence();
		idSequenceMapper.insert(idSequence);
		String parternerID = "par" + Long.toString(idSequence.getId());
		parterner.setId(parternerID);
		parterner.setCreateTime(new Date());
		parternerMapper.insert(parterner);
		return parterner;
	}

	public List<Parterner> listParterner(int count, int page) throws ToyException {
		Limit limit = new Limit();
		limit.setRowcount(count);
		limit.setOffset(count * (page - 1));
		ParternerExample example = new ParternerExample();
		example.setLimitClause(limit);
		return parternerMapper.selectByExampleWithLimit(example);
	}

	public List<Parterner> findParternerByName(String name) throws ToyException {
		ParternerExample example = new ParternerExample();
		example.createCriteria().andNameLike("%" + name + "%");
		return parternerMapper.selectByExample(example);
	}

	public Parterner getParterById(String id) throws ToyException {
		return parternerMapper.selectByPrimaryKey(id);
	}

	public Parterner updateParterner(Parterner parterner) throws ToyException {
		Parterner originalPartner  = parternerMapper.selectByPrimaryKey(parterner.getId());
		parterner.setCreateTime(originalPartner.getCreateTime());
		parternerMapper.updateByPrimaryKey(parterner);
		return parterner;
	}

	public int getParterCount() throws ToyException {
		return parternerMapper.countByExample(null);
	}
}
