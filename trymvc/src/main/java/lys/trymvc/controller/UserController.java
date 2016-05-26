package lys.trymvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.toy.service.UserService;
import com.toy.model.generate.User;
import com.toy.model.generate.UserCoin;
import com.toy.model.generate.UserToken;
import com.toy.service.InvalidPasswordException;
import com.toy.service.OpResult;
import com.toy.service.ToyException;
import com.toy.service.UserNotFoundException;

@Controller(value = "user")
@RequestMapping(value = "/user")
public class UserController extends ControllerBase {
	private UserService userService;

	@RequestMapping(value = "/get")
	public @ResponseBody OpResult getuser(String id, HttpServletResponse response) {
		allowAccess(response);
		User user = null;
		OpResult result = new OpResult();
		try {
			user = userService.getUser(id);
			if (user != null) {
				result.setSuccess(true);
				result.setData(user);
			}else{
				result.setSuccess(false);
				result.setCode("fail_get_user");
				result.setDesc("fail to get user");
			}
		} catch (Exception e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_get_user");
			result.setDesc("fail to get user");
		}
		return result;
	}

	@RequestMapping(value = "/create")
	public @ResponseBody OpResult createUser(User user, HttpServletResponse response) {
		allowAccess(response);
		User createdUser = null;
		OpResult result = new OpResult();
		try {
			createdUser = userService.createUser(user);
			result.setSuccess(true);
			result.setData(createdUser);
		} catch (Exception e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_create_user");
			result.setDesc("fail to create user.");
		}
		return result;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody OpResult updateUser(User user, HttpServletResponse response) {
		allowAccess(response);
		User updatedUser = null;
		OpResult result = new OpResult();
		try {
			updatedUser = userService.updateUser(user);
			result.setSuccess(true);
			result.setData(updatedUser);
		} catch (Exception e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_update_user");
			result.setDesc("fail to update user.");
		}
		return result;
	}

	// @RequestMapping(value="/addimg")
	// public @ResponseBody OpResult upload(MultipartFile file,
	// HttpServletResponse response) throws IOException {
	// allowAccess(response);
	// System.out.println("################################upload");
	// FileCopyUtils.copy(file.getBytes(), new File("d:\\temp\\" +
	// file.getOriginalFilename()));
	// OpResult result = new OpResult();
	// result.setCode("");
	// return result;
	// }

	@RequestMapping(value = "/count")
	public @ResponseBody OpResult list(HttpServletResponse response) throws IOException {
		allowAccess(response);
		int count = 0;
		OpResult result = new OpResult();

		try {
			count = userService.getUserCount();
			result.setSuccess(true);
			result.setData(count);
		} catch (ToyException e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_count_user");
			result.setDesc("fail to get user count.");
		}
		return result;
	}

	@RequestMapping(value = "/list")
	public @ResponseBody OpResult list(int count, int page, HttpServletResponse response) throws IOException {
		allowAccess(response);
		List<User> users = null;
		OpResult result = new OpResult();

		try {
			users = userService.listUsers(count, page);
			result.setSuccess(true);
			result.setData(users);
		} catch (ToyException e) {
			// TODO log exception
			result.setSuccess(false);
			result.setCode("fail_list_user");
			result.setDesc("fail to get user list.");
		}
		return result;
	}

	@RequestMapping(value = "/login")
	public @ResponseBody OpResult login(String username, String password, HttpServletResponse response)
			throws IOException {
		allowAccess(response);
		UserToken useToken = null;
		OpResult result = new OpResult();

		try {
			useToken = userService.login(username, password);
			result.setSuccess(true);
			result.setData(useToken);
		} catch (Exception e) {
			// TODO log exception
			String code = "fail_login";
			String desc = "fail to login";
			if (e instanceof UserNotFoundException) {
				desc = "user not found";
			} else if (e instanceof InvalidPasswordException) {
				desc = "invalid password";
			}
			result.setSuccess(false);
			result.setCode(code);
			result.setDesc(desc);
		}
		return result;
	}

	@RequestMapping(value = "/find")
	public @ResponseBody OpResult findByName(String username, HttpServletResponse response) throws IOException {
		allowAccess(response);
		List<User> users = null;
		OpResult result = new OpResult();

		try {
			users = userService.findUserByName(username);
			result.setSuccess(true);
			result.setData(users);
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

	@RequestMapping(value = "/getCoin")
	public @ResponseBody OpResult getCoin(String userId, HttpServletResponse response) throws IOException {
		allowAccess(response);
		UserCoin userCoin = null;
		OpResult result = new OpResult();

		try {
			userCoin = userService.getUserCoin(userId);
			result.setSuccess(true);
			result.setData(userCoin);
		} catch (Exception e) {
			// TODO log exception
			String code = "fail_get_coin";
			String desc = "fail to get coin";
			result.setSuccess(false);
			result.setCode(code);
			result.setDesc(desc);
		}
		return result;
	}

	@RequestMapping(value = "/updateCoin")
	public @ResponseBody OpResult updateCoin(UserCoin userCoin, HttpServletResponse response) throws IOException {
		allowAccess(response);
		UserCoin updatedCoin = null;
		OpResult result = new OpResult();

		try {
			updatedCoin = userService.updateUserCoin(userCoin.getUserId(), userCoin.getCount());
			result.setSuccess(true);
			result.setData(updatedCoin);
		} catch (Exception e) {
			// TODO log exception
			String code = "fail_update_coin";
			String desc = "fail to update coin";
			result.setSuccess(false);
			result.setCode(code);
			result.setDesc(desc);
		}
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