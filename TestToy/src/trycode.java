import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class trycode {

	public static void main(String[] args) throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		DecompressingHttpClient client = new DecompressingHttpClient(httpclient);
		for(int i=0; i<26; i++){
			char c = (char) (i+'a');
			for(int j=0; j<10; j++){
				String code = "a317"+j+"0d7b9"+c+"d2004";
//				String code = "a317*0d7b9*d2004";
				String url = "http://xy.xyzcl.xyz/register.php";				
				HttpPost httpPost = new HttpPost(url);
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				nvps.add(new BasicNameValuePair("action", "reginvcodeck"));
				nvps.add(new BasicNameValuePair("reginvcode", code));
				httpPost.setEntity(new UrlEncodedFormEntity(nvps));
				HttpResponse response = client.execute(httpPost);
				String result = EntityUtils.toString(response.getEntity());
				if(result.contains("retmsg_invcode('1')")){
					System.out.println("fail");
				}else{
					System.out.println("!!!!!!!!!!!!!!!!!!!!!");
					System.out.println(code);
					break;
				}
			}			
			Thread.sleep(500);
		}
		httpclient.close();
	}

}
