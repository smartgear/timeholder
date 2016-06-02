import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestBase {

	protected static String jdbc_url = "jdbc:mysql://localhost:3306/toy";
	protected static String jdbc_username = "root";
	protected static String jdbc_password = "12345678";
	protected static String jdbc_driver = "com.mysql.jdbc.Driver";
	private static String sql_delete_parterner = "delete from parterner";

	public TestBase() {
		super();
	}

	public static Map jsontoMap(String result) throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		Map map = objMapper.readValue(result, Map.class);
		return map;
	}

	public static CloseableHttpResponse createParterner(String name, String desc, String linkman, String email,
			String mobile, String telephone, String address) throws Exception {
		String url = "http://localhost:18080/trymvc/lys/parterner/create";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
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

	public static void deleteParterner() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql_delete_parterner);
	}

}