package ws;

import com.ws.client.Hello;
import com.ws.client.HelloImplService;

import junit.framework.TestCase;

public class HelloClient extends TestCase {

	public void testHello(){
		Hello client = new HelloImplService().getHelloPort();
		String actual = client.hello("Raphael");
		String expected = "Hello Raphael";
		assertEquals(expected, actual);
	}
}
