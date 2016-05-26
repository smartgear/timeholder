package lys.trymvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toy.model.generate.Parterner;
import com.toy.model.generate.User;
import com.toy.service.OpResult;
import com.toy.service.ParternerService;
import com.toy.service.ToyException;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller(value = "parterner")
@RequestMapping(value = "/parterner")
public class ParternerController extends ControllerBase {
	private ParternerService parternerService;

	public ParternerService getParternerService() {
		return parternerService;
	}

	@Resource
	public void setParternerService(ParternerService parternerService) {
		this.parternerService = parternerService;
	}

	@RequestMapping(value = "/create")
	public @ResponseBody OpResult createParterner(Parterner parterner, HttpServletResponse response) {
		allowAccess(response);
		Parterner createdParterner = null;
		OpResult result = new OpResult();
		try {
			createdParterner = parternerService.addParter(parterner);
			result.setSuccess(true);
			result.setData(createdParterner);
		} catch (Exception e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_create_parterner");
			result.setDesc("fail to create parterner.");
		}
		return result;
	}
	
	@RequestMapping(value = "/count")
	public @ResponseBody OpResult list(HttpServletResponse response) throws IOException {
		allowAccess(response);
		int count = 0;
		OpResult result = new OpResult();

		try {
			count = parternerService.getParterCount();
			result.setSuccess(true);
			result.setData(count);
		} catch (ToyException e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_count_parterner");
			result.setDesc("fail to get parterner count.");
		}
		return result;
	}
	
	@RequestMapping(value = "/list")
	public @ResponseBody OpResult list(int count, int page, HttpServletResponse response) throws IOException {
		allowAccess(response);
		List<Parterner> parterners = null;
		OpResult result = new OpResult();

		try {
			parterners = parternerService.listParterner(count, page);
			result.setSuccess(true);
			result.setData(parterners);
		} catch (ToyException e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_list_parterner");
			result.setDesc("fail to get parterner list.");
		}
		return result;
	}
	
	@RequestMapping(value = "/get")
	public @ResponseBody OpResult getuser(String id, HttpServletResponse response) {
		allowAccess(response);
		Parterner parterner = null;
		OpResult result = new OpResult();
		try {
			parterner = parternerService.getParterById(id);
			result.setSuccess(true);
			result.setData(parterner);
		} catch (Exception e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_get_parterner");
			result.setDesc("fail to get parterner");
		}
		return result;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody OpResult updateUser(Parterner parterner, HttpServletResponse response) {
		allowAccess(response);
		Parterner updatedParterner = null;
		OpResult result = new OpResult();
		try {
			updatedParterner = parternerService.updateParterner(parterner);
			result.setSuccess(true);
			result.setData(updatedParterner);
		} catch (Exception e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_update_parterner");
			result.setDesc("fail to update parterner.");
		}
		return result;
	}
	
	@RequestMapping(value = "/find")
	public @ResponseBody OpResult findByName(String name, HttpServletResponse response) throws IOException {
		allowAccess(response);
		List<Parterner> parterners = null;
		OpResult result = new OpResult();

		try {
			parterners = parternerService.findParternerByName(name);
			result.setSuccess(true);
			result.setData(parterners);
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
}
