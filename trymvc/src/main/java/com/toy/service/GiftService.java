package com.toy.service;

import java.util.List;

import com.toy.model.generate.Gift;

public interface GiftService {
	public int getGiftCount() throws ToyException;	
	
	public Gift getGiftByID(String id) throws ToyException;
	
	public List<Gift> findGiftByName(String name) throws ToyException;
	
	public List<Gift> listGifts(int count, int page) throws ToyException;
	
	public Gift updateGift(Gift gift) throws ToyException;
	
	public Gift addGift(Gift gift) throws ToyException;	
	
}
