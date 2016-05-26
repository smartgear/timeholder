package trygenerator;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.toy.dao.IDSequenceDAO;
import com.toy.dao.UserDAO;
import com.toy.model.generate.IdSequence;
import com.toy.model.generate.User;
import static org.junit.Assert.*;

public class MyTest {
	
	public void testCreateUser() throws Exception {
		User user = null;

		for (int i = 0; i < 100; i++) {
			user = new User();
			user.setUserId("u"+i);
			user.setUsername("name_u"+i);
			user.setPassword("123456");
			user.setEmail("abc@def.com");
			user.setMobile("12312345678");
			user.setRole("admin");
			user.setSalt("12345678");
			user.setCreateTime(new Date());
			UserDAO udao = new UserDAO();
			udao.addUser(user);
		}
	}
	
	
	public void testListUser() throws Exception{
		UserDAO udao = new UserDAO();
		List<User> users = udao.listUser(0, 10);
		assertEquals(users.size(), 10);
		for(int i=0; i<10; i++){
			System.out.println(users.get(i).getUsername());
		}
	}
	
	@Test
	public void testCreateNewID() throws Exception{
		IDSequenceDAO idDao = new IDSequenceDAO();
		IdSequence id = idDao.create();
		System.out.println(id.getId());
		id = idDao.create();
		System.out.println(id.getId());
	}
}