package lys.trymvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.toy.service.UserService;
import com.toy.service.OpResult;

@Controller(value="service")
@RequestMapping(value = "/service")
public class ServiceController {
	private UserService userService;
	


//	@RequestMapping(value="/get")	
//	public @ResponseBody User getuser(String id) {
//		System.out.println("################################lys");
//		System.out.println("id: " + id);
//		User u = new User();
//		u.setId("testId");
//		u.setName("getName");
//		u.setPassword("testPassword");
//		return u;
//	}
//	
//	@RequestMapping(value="/create")	
//	public @ResponseBody OpResult createUser(String username, String password, HttpServletResponse response) {
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		System.out.println("################################create user");
//		System.out.println("username: " + username);
//		System.out.println("password: " + password);
//		User u = new User();
//		u.setId("testId");
//		u.setName(username);
//		u.setPassword(password);
//		OpResult result = new OpResult();
//		result.setCode("");
//		return result;
//	}
	
	@RequestMapping(value="/upload")	
	public @ResponseBody OpResult upload(MultipartFile file, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("################################upload");
		FileCopyUtils.copy(file.getBytes(), new File("d:\\temp\\" + file.getOriginalFilename()));        
		OpResult result = new OpResult();
		result.setCode("");
		return result;
	}
	
	@RequestMapping(value="/list")	
	public @ResponseBody OpResult list(HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("################################list");
		OpResult result= new OpResult();
		List<com.toy.model.generate.User> users = userService.listUsers(100, 1);
		result.setData(users);
		return result;
	}
	
	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}	
}