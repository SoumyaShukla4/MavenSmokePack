package APITest.APITest;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetRequest {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		CloseableHttpClient ClosableHttpClient = HttpClients.createDefault(); //we use HttpClient here because we will automate API using HttpClient
		HttpGet get =new HttpGet("https://reqres.in/api/users?page=2");
		CloseableHttpResponse closableHttpResponse = ClosableHttpClient.execute(get);

		int statusCode = closableHttpResponse.getStatusLine().getStatusCode();

		System.out.println(statusCode);

		//Below code is to read headers

		/*Header[] headers = closableHttpResponse.getAllHeaders();
		for(int i=0;i<headers.length;i++)
		{
			String HeaderKey = headers[i].getName();
			String HeaderValue = headers[i].getValue();

			System.out.println(headers.length);
			System.out.println(HeaderKey + "------>" + HeaderValue);
		}
		*/
		
		//below code is to read the response body
		
		String response = EntityUtils.toString(closableHttpResponse.getEntity(), "UTF-8");
		System.out.println(response);
		
	}

}
