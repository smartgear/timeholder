package com.toy.service.impl;

import java.util.Date;

import com.toy.data.generate.IdSequenceMapper;
import com.toy.data.generate.ImageMapper;
import com.toy.model.generate.IdSequence;
import com.toy.model.generate.Image;
import com.toy.service.ToyException;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("imageService")
public class ImageServiceImpl implements com.toy.service.ImageService {
	private ImageMapper imageMapper;
	private IdSequenceMapper idSequenceMapper;
	

	public Image getImageByID(String id) throws ToyException {
		
		return null;
	}

	public Image addImage(Image image) throws ToyException {
		IdSequence idSequence = new IdSequence();
		idSequenceMapper.insert(idSequence);
		String imgID = "img" + Long.toString(idSequence.getId());
		image.setId(imgID);
		image.setCreateDate(new Date());
		imageMapper.insert(image);
		return image;
	}
	

	public IdSequenceMapper getIdSequenceMapper() {
		return idSequenceMapper;
	}

	@Resource
	public void setIdSequenceMapper(IdSequenceMapper idSequenceMapper) {
		this.idSequenceMapper = idSequenceMapper;
	}

	public ImageMapper getImageMapper() {
		return imageMapper;
	}

	@Resource
	public void setImageMapper(ImageMapper imageMapper) {
		this.imageMapper = imageMapper;
	}
}
