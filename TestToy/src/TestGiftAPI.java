import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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

public class TestGiftAPI extends TestBase {
	private String sql_delete_gift = "delete from gift";
	private String sql_get_gift_count = "select count(*) from gift";
	private static String parternerid;
	private Log logger;

	public TestGiftAPI() {
		logger = LogFactory.getLog("TestGiftAPI");
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		CloseableHttpResponse response = createParterner("parterner1", "testparterner", "卜卜", "parterner1@daishumm.com",
				"13811111111", "68881234", "常营");
		Map map = jsontoMap(EntityUtils.toString(response.getEntity()));
		parternerid = (String) ((Map) map.get("data")).get("id");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		deleteParterner();
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		deleteGift();
	}

	@Test
	public void testCreate() throws Exception {
		logger.info("testCreateGift");
		CloseableHttpResponse response = createGift(parternerid, "电话卡", "50元面额", "100", "5000", "True");
		try {
			HttpEntity entity = response.getEntity();
			System.out.println(EntityUtils.toString(entity));
		} finally {
			response.close();
		}
		int count = getGiftCount();
		assertEquals(1, count);
	}

	@Test
	public void testGet() throws Exception {
		logger.info("testGet");
		CloseableHttpResponse response = createGift(parternerid, "电话卡", "50元面额", "100", "5000", "True");
		Map createResult = jsontoMap(EntityUtils.toString(response.getEntity()));
		String giftID = (String) (((Map) createResult.get("data")).get("id"));
		CloseableHttpResponse getResponse = get(giftID);
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

		for (int i = 0; i < 111; i++) {
			CloseableHttpResponse response = createGift(parternerid, "电话卡", "50元面额", "100", "5000", "True");
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
		CloseableHttpResponse response = createGift(parternerid, "电话卡", "50元面额", "100", "5000", "True");
		Map map = jsontoMap(EntityUtils.toString(response.getEntity()));
		String giftID = (String) ((Map) map.get("data")).get("id");

		CloseableHttpResponse updateResponse = updateGift(giftID,parternerid, "交通卡", "50元面额", "100", "5000", "True");
		try {
			HttpEntity entity = updateResponse.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println(result);
			Map updateResultMap = jsontoMap(result);
			assertTrue((Boolean) updateResultMap.get("success"));
			assertEquals((String) ((Map) updateResultMap.get("data")).get("name"), "交通卡");
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
			createGift(parternerid, name, "50元面额", "100", "5000", "True");
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
			name = "gift" + Integer.toString(i) + "_aa";
			createGift(parternerid, name, "50元面额", "100", "5000", "True");
		}

		for (int i = 0; i < 5; i++) {
			name = "gift" + Integer.toString(i) + "_bb";
			createGift(parternerid, name, "50元面额", "100", "5000", "True");
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

	private CloseableHttpResponse createGift(String parternerId, String name, String desc, String count, String price,
			String available) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/gift/create";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("parternerId", parternerId));
		nvps.add(new BasicNameValuePair("name", name));
		nvps.add(new BasicNameValuePair("desc", desc));
		nvps.add(new BasicNameValuePair("count", count));
		nvps.add(new BasicNameValuePair("price", price));
		nvps.add(new BasicNameValuePair("available", available));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}
	
	private CloseableHttpResponse updateGift(String giftId, String parternerId, String name, String desc, String count, String price,
			String available) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/gift/create";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("id", giftId));
		nvps.add(new BasicNameValuePair("parternerId", parternerId));
		nvps.add(new BasicNameValuePair("name", name));
		nvps.add(new BasicNameValuePair("desc", desc));
		nvps.add(new BasicNameValuePair("count", count));
		nvps.add(new BasicNameValuePair("price", price));
		nvps.add(new BasicNameValuePair("available", available));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}
	
	private CloseableHttpResponse list(int count, int page) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/gift/list";
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
		String url = "http://localhost:18080/trymvc/lys/gift/find";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("name", name));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}

	private CloseableHttpResponse get(String giftId) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/gift/get";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("id", giftId));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}

	private CloseableHttpResponse count() throws Exception {
		String url = "http://localhost:18080/trymvc/lys/gift/count";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		return response;
	}

	public int getGiftCount() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
		stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery(sql_get_gift_count);
		resultSet.next();
		int count = resultSet.getInt(1);
		conn.close();
		return count;
	}

	public void deleteGift() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql_delete_gift);
	}

}
