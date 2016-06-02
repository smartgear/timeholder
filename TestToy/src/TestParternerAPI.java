import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestParternerAPI extends TestBase{
	private String sql_get_parterner_count = "select count(*) from parterner";
	private Log logger;
	
	public TestParternerAPI() {
		logger = LogFactory.getLog("TestUserAPI");
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		deleteParterner();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() throws Exception {
		logger.info("testCreateParterner");
		CloseableHttpResponse response = createParterner("parterner1", "testparterner", "卜卜",
				"parterner1@daishumm.com", "13811111111","68881234","常营");
		try {
			HttpEntity entity = response.getEntity();
			System.out.println(EntityUtils.toString(entity));
		} finally {
			response.close();
		}
		int count = getParternerCount();
		assertEquals(1, count);
	}
	
	@Test
	public void testGet() throws Exception {
		logger.info("testGet");
		CloseableHttpResponse response =createParterner("parterner1", "testparterner", "卜卜",
				"parterner1@daishumm.com", "13811111111","68881234","常营");
		Map createResult = jsontoMap(EntityUtils.toString(response.getEntity()));
		String parternerID = (String) (((Map) createResult.get("data")).get("id"));
		CloseableHttpResponse getResponse = get(parternerID);
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
		String parternername = "";

		for (int i = 0; i < 111; i++) {
			parternername = "parterner" + Integer.toString(i);
			createParterner(parternername, "testparterner", "卜卜",
					"parterner1@daishumm.com", "13811111111","68881234","常营");
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
	public void testUpdateParterner() throws Exception {
		logger.info("testUpdate");
		CloseableHttpResponse response = createParterner("parterner1", "testparterner", "卜卜",
				"parterner1@daishumm.com", "13811111111","68881234","常营");
		Map map = jsontoMap(EntityUtils.toString(response.getEntity()));
		String parternerid = (String) ((Map) map.get("data")).get("id");

		CloseableHttpResponse updateResponse = updateParterner(parternerid, "parterner1", "updated", "卜卜",
				"parterner1@daishumm.com", "13811111111","68881234","常营");
		try {
			HttpEntity entity = updateResponse.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map updateResultMap = jsontoMap(result);
			assertTrue((Boolean) updateResultMap.get("success"));
			assertEquals((String) ((Map) updateResultMap.get("data")).get("desc"), "updated");
		} finally {
			response.close();
		}
	}

	@Test
	public void testList() throws Exception {
		logger.info("testlist");
		String name = "";

		for (int i = 0; i < 111; i++) {
			name = "parterner" + Integer.toString(i);
			 createParterner(name, "testparterner", "卜卜",
						"parterner1@daishumm.com", "13811111111","68881234","常营");
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
		String name = "";
		for (int i = 0; i < 5; i++) {
			name = "parterner" + Integer.toString(i) + "_aa";
			 createParterner(name, "testparterner", "卜卜",
						"parterner1@daishumm.com", "13811111111","68881234","常营");
		}

		for (int i = 0; i < 5; i++) {
			name = "parterner" + Integer.toString(i) + "_bb";
			 createParterner(name, "testparterner", "卜卜",
						"parterner1@daishumm.com", "13811111111","68881234","常营");
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



	private CloseableHttpResponse updateParterner(String id,String name, String desc, String linkman, String email, String mobile,
			String telephone, String address) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/parterner/update";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("id", id));
		nvps.add(new BasicNameValuePair("name", name));
		nvps.add(new BasicNameValuePair("desc", desc));
		nvps.add(new BasicNameValuePair("linkman", linkman));
		nvps.add(new BasicNameValuePair("mail", email));
		nvps.add(new BasicNameValuePair("mobile", mobile));
		nvps.add(new BasicNameValuePair("telephone", telephone));
		nvps.add(new BasicNameValuePair("address", address));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}
	
	
	private CloseableHttpResponse get(String parternerId) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/parterner/get";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("id", parternerId));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}
	
	private CloseableHttpResponse count() throws Exception {
		String url = "http://localhost:18080/trymvc/lys/parterner/count";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}
	
	private CloseableHttpResponse list(int count, int page) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/parterner/list";
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
		String url = "http://localhost:18080/trymvc/lys/parterner/find";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("name", name));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}
	
	public int getParternerCount() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
		stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery(sql_get_parterner_count);
		resultSet.next();
		int count = resultSet.getInt(1);
		conn.close();
		return count;
	}

}
