package com.toy.service;

import java.util.List;

import com.toy.model.generate.Parterner;

public interface ParternerService {
	public Parterner addParter(Parterner parterner) throws ToyException;
	
	public int getParterCount() throws ToyException;
	
	public List<Parterner> listParterner(int count, int page) throws ToyException;
	
	public List<Parterner> findParternerByName(String name) throws ToyException;
	
	public Parterner getParterById(String id) throws ToyException;
	
	public Parterner updateParterner(Parterner parterner) throws ToyException;

}
