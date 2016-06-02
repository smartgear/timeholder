import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;

public class TestUserAPI extends TestBase {

	private String sql_delete_user = "delete from user";
	private String sql_delete_user_coin = "delete from user_coin";
	private String sql_delete_user_token = "delete from user_token";
	private String sql_get_user_count = "select count(*) from user";

	private Log logger;

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	public TestUserAPI() {
		logger = LogFactory.getLog("TestUserAPI");
	}

	@Test
	public void testCreateUser() throws Exception {
		logger.info("testCreateUser");
		CloseableHttpResponse response = createUser("user1", "user1_pass", "admin", "test", "test",
				"user1@daishumm.com", "13811111111", "active");
		try {
			HttpEntity entity = response.getEntity();
			System.out.println(EntityUtils.toString(entity));
		} finally {
			response.close();
		}
		int count = getUserCount();
		assertEquals(1, count);
	}

	@Test
	public void testLogin() throws Exception {
		logger.info("testLogin");
		String username = "user1";
		String password = "testpwd";
		createUser(username, password, "admin", "test", "test", "user1@daishumm.com", "13811111111", "active");
		CloseableHttpResponse response = login(username, password);
		try {
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map map = jsontoMap(result);
			assertTrue((Boolean) map.get("success"));
		} finally {
			response.close();
		}

		CloseableHttpResponse response2 = login(username, "invalidPwd");
		try {
			HttpEntity entity = response2.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map map = jsontoMap(result);
			assertTrue(!(Boolean) map.get("success"));
		} finally {
			response2.close();
		}
	}

	@Test
	public void testGet() throws Exception {
		logger.info("testGet");
		String username = "user1";
		String password = "testpwd";
		CloseableHttpResponse response = createUser(username, password, "admin", "test", "test", "user1@daishumm.com",
				"13811111111", "active");
		Map createResult = jsontoMap(EntityUtils.toString(response.getEntity()));
		String userId = (String) (((Map) createResult.get("data")).get("userId"));
		CloseableHttpResponse getResponse = get(userId);
		try {
			HttpEntity entity = getResponse.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map map = jsontoMap(result);
			assertTrue((Boolean) map.get("success"));
		} finally {
			getResponse.close();
		}
	}

	@Test
	public void testCount() throws Exception {
		logger.info("testCount");
		String username = "user1";
		String password = "testpwd";

		for (int i = 0; i < 111; i++) {
			username = "user" + Integer.toString(i);
			createUser(username, password, "admin", "test", "test", "user1@daishumm.com", "13811111111", "active");
		}
		CloseableHttpResponse getResponse = count();
		try {
			HttpEntity entity = getResponse.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map map = jsontoMap(result);
			assertTrue((Boolean) map.get("success"));
			assertEquals(111, map.get("data"));
		} finally {
			getResponse.close();
		}
	}

	@Test
	public void testUpdateUser() throws Exception {
		logger.info("testUpdateUser");
		CloseableHttpResponse response = createUser("user1", "user1_pass", "admin", "test", "test",
				"user1@daishumm.com", "13811111111", "active");
		Map map = jsontoMap(EntityUtils.toString(response.getEntity()));
		String uid = (String) ((Map) map.get("data")).get("userId");

		CloseableHttpResponse updateResponse = updateUser(uid, "user1", "pass1", "admin", "test", "test",
				"user1@daishumm.com", "13811111111", "disabled");
		try {
			HttpEntity entity = updateResponse.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map updateResultMap = jsontoMap(result);
			assertTrue((Boolean) updateResultMap.get("success"));
			assertEquals((String) ((Map) updateResultMap.get("data")).get("state"), "disabled");
		} finally {
			response.close();
		}

		CloseableHttpResponse loginResponse = login("user1", "pass1");
		try {
			HttpEntity loginEntity = loginResponse.getEntity();
			String loginresult = EntityUtils.toString(loginEntity);
			System.out.println(loginresult);
			Map loginMap = jsontoMap(loginresult);
			assertTrue((Boolean) map.get("success"));
		} finally {
			loginResponse.close();
		}
	}

	@Test
	public void testList() throws Exception {
		logger.info("testlist");
		String username = "user1";
		String password = "testpwd";

		for (int i = 0; i < 111; i++) {
			username = "user" + Integer.toString(i);
			createUser(username, password, "admin", "test", "test", "user1@daishumm.com", "13811111111", "active");
		}
		CloseableHttpResponse getResponse = list(10, 11);
		try {
			HttpEntity entity = getResponse.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map map = jsontoMap(result);
			assertTrue((Boolean) map.get("success"));
			assertEquals(10, ((List) map.get("data")).size());
		} finally {
			getResponse.close();
		}
	}

	@Test
	public void testFind() throws Exception {
		logger.info("testfind");
		String username = "user1";
		String password = "testpwd";

		for (int i = 0; i < 5; i++) {
			username = "user" + Integer.toString(i) + "_aa";
			createUser(username, password, "admin", "test", "test", "user1@daishumm.com", "13811111111", "active");
		}

		for (int i = 0; i < 5; i++) {
			username = "user" + Integer.toString(i) + "_bb";
			createUser(username, password, "admin", "test", "test", "user1@daishumm.com", "13811111111", "active");
		}
		CloseableHttpResponse getResponse = find("_aa");
		try {
			HttpEntity entity = getResponse.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map map = jsontoMap(result);
			assertTrue((Boolean) map.get("success"));
			assertEquals(5, ((List) map.get("data")).size());
		} finally {
			getResponse.close();
		}
	}

	@Test
	public void testGetCoin() throws Exception {
		logger.info("testGetCoin");
		CloseableHttpResponse response = createUser("user1", "user1_pass", "admin", "test", "test",
				"user1@daishumm.com", "13811111111", "active");
		Map map = jsontoMap(EntityUtils.toString(response.getEntity()));
		String uid = (String) ((Map) map.get("data")).get("userId");

		CloseableHttpResponse getResponse = getCoin(uid);
		try {
			HttpEntity entity = getResponse.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map coinMap = jsontoMap(result);
			assertTrue((Boolean) map.get("success"));
			assertEquals(0, ((Integer)((Map) coinMap.get("data")).get("count")).intValue());
		} finally {
			getResponse.close();
		}
	}

	@Test
	public void testUpdateCoin() throws Exception {
		logger.info("testUpdateCoin");
		CloseableHttpResponse response = createUser("user1", "user1_pass", "admin", "test", "test",
				"user1@daishumm.com", "13811111111", "active");
		Map map = jsontoMap(EntityUtils.toString(response.getEntity()));
		String uid = (String) ((Map) map.get("data")).get("userId");

		CloseableHttpResponse getResponse = getCoin(uid);
		try {
			HttpEntity entity = getResponse.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map coinMap = jsontoMap(result);
			assertTrue((Boolean) map.get("success"));
			assertEquals(0, ((Integer)((Map) coinMap.get("data")).get("count")).intValue());			
		} finally {
			getResponse.close();
		}		
		updateCoin(uid,998);
		
		getResponse = getCoin(uid);
		try {
			HttpEntity entity = getResponse.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map coinMap = jsontoMap(result);
			assertTrue((Boolean) map.get("success"));
			assertEquals(998, ((Integer)((Map) coinMap.get("data")).get("count")).intValue());			
		} finally {
			getResponse.close();
		}
		
	}

	@Before
	public void cleanUserTable() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql_delete_user_coin);
		stmt.executeUpdate(sql_delete_user_token);
		stmt.executeUpdate(sql_delete_user);
		conn.close();
	}

	public int getUserCount() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
		stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery(sql_get_user_count);
		resultSet.next();
		int count = resultSet.getInt(1);
		conn.close();
		return count;
	}

	private CloseableHttpResponse createUser(String username, String password, String role, String extid, String from,
			String email, String mobile, String state) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/user/create";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("username", username));
		nvps.add(new BasicNameValuePair("password", password));
		nvps.add(new BasicNameValuePair("from", from));
		nvps.add(new BasicNameValuePair("email", email));
		nvps.add(new BasicNameValuePair("mobile", mobile));
		nvps.add(new BasicNameValuePair("role", role));
		nvps.add(new BasicNameValuePair("state", state));
		nvps.add(new BasicNameValuePair("extid", from));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}

	private CloseableHttpResponse updateUser(String userId, String username, String password, String role, String extid,
			String from, String email, String mobile, String state) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/user/update";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("userId", userId));
		nvps.add(new BasicNameValuePair("username", username));
		nvps.add(new BasicNameValuePair("password", password));
		nvps.add(new BasicNameValuePair("from", from));
		nvps.add(new BasicNameValuePair("email", email));
		nvps.add(new BasicNameValuePair("mobile", mobile));
		nvps.add(new BasicNameValuePair("role", role));
		nvps.add(new BasicNameValuePair("state", state));
		nvps.add(new BasicNameValuePair("extid", extid));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}

	private CloseableHttpResponse login(String username, String password) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/user/login";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("username", username));
		nvps.add(new BasicNameValuePair("password", password));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}

	private CloseableHttpResponse get(String uid) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/user/get";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("id", uid));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}

	private CloseableHttpResponse count() throws Exception {
		String url = "http://localhost:18080/trymvc/lys/user/count";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}

	private CloseableHttpResponse list(int count, int page) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/user/list";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("count", Integer.toString(count)));
		nvps.add(new BasicNameValuePair("page", Integer.toString(page)));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}

	private CloseableHttpResponse find(String name) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/user/find";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("username", name));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}
	
	private CloseableHttpResponse getCoin(String userId) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/user/getCoin";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("userId", userId));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}
	
	private CloseableHttpResponse updateCoin(String userId, int count) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/user/updateCoin";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("userId", userId));
		nvps.add(new BasicNameValuePair("count", Integer.toString(count)));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}
}
