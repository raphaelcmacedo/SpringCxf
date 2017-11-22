package ws;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXB;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.ws.entity.Site;

public class RestClient extends TestCase {
	private static String BASE_URL = "http://localhost:8081/api/";
	private static CloseableHttpClient client;

	protected void setUp() throws Exception {
		client = HttpClients.createDefault();
	}

	protected void tearDown() throws Exception {
		client.close();
	}

	public void testGetSite() throws IOException {
		URL url = new URL(BASE_URL + "site/22");
		InputStream input = url.openStream();
		Site result = JAXB.unmarshal(new InputStreamReader(input), Site.class);
		Assert.assertEquals("Belgium", result.getName());

	}

	public void testCreateSite() throws IOException {
		URL url = new URL(BASE_URL + "site/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "text/xml");
		connection.setRequestProperty("Content-Type", "text/xml");
		connection.setDoOutput(true);

		Site site = new Site();
		site.setName("Nova Friburgo");
		JAXB.marshal(site, connection.getOutputStream());
		
		Site result = JAXB.unmarshal(new InputStreamReader(connection.getInputStream()), Site.class);
		connection.disconnect();
		
		Assert.assertEquals("Nova Friburgo", result.getName()); 
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
