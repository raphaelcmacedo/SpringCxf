package ws;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXB;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.ws.entity.Site;

public class RestClient extends TestCase {
	private static String BASE_URL = "http://localhost:8081/api/";

	private HttpURLConnection createConnection(URL url, String method) throws IOException{
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(method);
		connection.setRequestProperty("Accept", "text/xml");
		connection.setRequestProperty("Content-Type", "text/xml");
		connection.setDoOutput(true);
		
		return connection;
	}
	
	public void testGetSite() throws IOException {
		URL url = new URL(BASE_URL + "site/22");
		InputStream input = url.openStream();
		Site result = JAXB.unmarshal(new InputStreamReader(input), Site.class);
		Assert.assertEquals("Belgium", result.getName());

	}

	public void testCreateDeleteSite() throws IOException {
		//Test creation
		URL url = new URL(BASE_URL + "site/");
		HttpURLConnection connection = this.createConnection(url, "POST");

		Site site = new Site();
		site.setName("Nova Friburgo");
		JAXB.marshal(site, connection.getOutputStream());
		
		Site result = JAXB.unmarshal(new InputStreamReader(connection.getInputStream()), Site.class);
		connection.disconnect();
		Assert.assertEquals("Nova Friburgo", result.getName());
		
		//Test deletion
		int id = result.getId();
		HttpDelete httpDelete = new HttpDelete(BASE_URL + "site/" + id);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse response = client.execute(httpDelete);
		assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();
	}
	
	public void testUpdateSite() throws IOException {
		URL url = new URL(BASE_URL + "site/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Accept", "text/xml");
		connection.setRequestProperty("Content-Type", "text/xml");
		connection.setDoOutput(true);

		Site site = new Site();
		site.setId(22);
		site.setName("Belgium");
		JAXB.marshal(site, connection.getOutputStream());
		
		Site result = JAXB.unmarshal(new InputStreamReader(connection.getInputStream()), Site.class);
		connection.disconnect();
		
		Assert.assertEquals("Belgium", result.getName()); 
	}
}
