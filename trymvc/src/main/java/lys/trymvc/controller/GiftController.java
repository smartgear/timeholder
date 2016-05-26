package lys.trymvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.toy.model.generate.Gift;
import com.toy.model.generate.GiftImageKey;
import com.toy.model.generate.Image;
import com.toy.service.GiftImageService;
import com.toy.service.GiftService;
import com.toy.service.ImageService;
import com.toy.service.OpResult;
import com.toy.service.ToyConfig;
import com.toy.service.ToyException;
import com.toy.service.impl.util.ImageUtil;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller(value="gift")
@RequestMapping(value = "/gift")
public class GiftController extends ControllerBase{
	private GiftService giftService;
	private ToyConfig toyConfig;
	private ImageService imageService;
	private GiftImageService giftImageService;



	@RequestMapping(value = "/create")
	public @ResponseBody OpResult createGift(MultipartFile file, Gift gift, HttpServletResponse response) {
		allowAccess(response);
		Gift createdGift = null;
		OpResult result = new OpResult();
		try {
			createdGift = giftService.addGift(gift);
			String oriName = file.getOriginalFilename();
			String newName = ImageUtil.saveImage(toyConfig.getImgPath(), file);
			Image image = new Image();
			image.setName(newName);
			imageService.addImage(image);
			GiftImageKey giftImage = new GiftImageKey();
			giftImage.setGiftId(createdGift.getId());
			giftImage.setImageId(image.getId());
			giftImageService.addGiftImage(giftImage);
			result.setSuccess(true);
			result.setData(createdGift);
		} catch (Exception e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_create_gift");
			result.setDesc("fail to create gift.");
		}
		return result;
	}
	
	@RequestMapping(value = "/create", method=RequestMethod.OPTIONS)
	public @ResponseBody OpResult CheckOption(HttpServletResponse response) {
		allowAccess(response);
		Gift createdGift = null;
		OpResult result = new OpResult();
		return result;
	}
	
	@RequestMapping(value = "/count")
	public @ResponseBody OpResult list(HttpServletResponse response) throws IOException {
		allowAccess(response);
		int count = 0;
		OpResult result = new OpResult();

		try {
			count = giftService.getGiftCount();
			result.setSuccess(true);
			result.setData(count);
		} catch (ToyException e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_count_gift");
			result.setDesc("fail to get gift count.");
		}
		return result;
	}
	
	@RequestMapping(value = "/list")
	public @ResponseBody OpResult list(int count, int page, HttpServletResponse response) throws IOException {
		allowAccess(response);
		List<Gift> gifts = null;
		OpResult result = new OpResult();

		try {
			gifts = giftService.listGifts(count, page);
			result.setSuccess(true);
			result.setData(gifts);
		} catch (ToyException e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_list_gift");
			result.setDesc("fail to get gift list.");
		}
		return result;
	}
	
	@RequestMapping(value = "/get")
	public @ResponseBody OpResult getuser(String id, HttpServletResponse response) {
		allowAccess(response);
		Gift gift = null;
		OpResult result = new OpResult();
		try {
			gift = giftService.getGiftByID(id);
			result.setSuccess(true);
			result.setData(gift);
		} catch (Exception e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_get_gift");
			result.setDesc("fail to get gift");
		}
		return result;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody OpResult updateUser(Gift gift, HttpServletResponse response) {
		allowAccess(response);
		Gift updatedGift = null;
		OpResult result = new OpResult();
		try {
			updatedGift = giftService.updateGift(gift);
			result.setSuccess(true);
			result.setData(updatedGift);
		} catch (Exception e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_update_gift");
			result.setDesc("fail to update gift.");
		}
		return result;
	}
	
	@RequestMapping(value = "/find")
	public @ResponseBody OpResult findByName(String name, HttpServletResponse response) throws IOException {
		allowAccess(response);
		List<Gift> gifts = null;
		OpResult result = new OpResult();

		try {
			gifts = giftService.findGiftByName(name);
			result.setSuccess(true);
			result.setData(gifts);
		} catch (Exception e) {
			// TODO log exception
			String code = "fail_find";
			String desc = "fail to find";
			result.setSuccess(false);
			result.setCode(code);
			result.setDesc(desc);
		}
		return result;
	}
	
	
	public GiftService getGiftService() {
		return giftService;
	}

	@Resource
	public void setGiftService(GiftService giftService) {
		this.giftService = giftService;
	}
	
	public ToyConfig getToyConfig() {
		return toyConfig;
	}

	@Resource
	public void setToyConfig(ToyConfig toyConfig) {
		this.toyConfig = toyConfig;
	}
	
	public ImageService getImageService() {
		return imageService;
	}

	@Resource
	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public GiftImageService getGiftImageService() {
		return giftImageService;
	}

	@Resource
	public void setGiftImageService(GiftImageService giftImageService) {
		this.giftImageService = giftImageService;
	}


}
