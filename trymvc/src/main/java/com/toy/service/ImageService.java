package com.toy.service;

import com.toy.model.generate.Image;

public interface ImageService {	
	public Image getImageByID(String id) throws ToyException;	
	public Image addImage(Image image) throws ToyException;	
}
