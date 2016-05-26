package com.toy.service.impl;

import com.toy.data.generate.GiftImageMapper;
import com.toy.model.generate.GiftImageKey;
import com.toy.service.GiftImageService;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("giftImageService")
public class GiftImageServiceImpl implements GiftImageService {
	private GiftImageMapper giftImageMapper;

	public GiftImageMapper getGiftImageMapper() {
		return giftImageMapper;
	}

	@Resource
	public void setGiftImageMapper(GiftImageMapper giftImageMapper) {
		this.giftImageMapper = giftImageMapper;
	}

	public GiftImageKey addGiftImage(GiftImageKey giftImage) {
		giftImageMapper.insert(giftImage);
		return giftImage;
	}

}
