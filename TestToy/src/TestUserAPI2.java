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

public class TestUserAPI2 extends TestBase {

	private String sql_delete_user = "delete from user";
	private String sql_delete_user_coin = "delete from user_coin";
	private String sql_delete_user_token = "delete from user_token";
	private String sql_get_user_count = "select count(*) from user";

	private Log logger;

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	public TestUserAPI2() {
		logger = LogFactory.getLog("TestUserAPI");
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
