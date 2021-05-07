package util;

import org.junit.Before;
import org.junit.Test;
import webserver.RequestHandler;

import java.net.Socket;

import static org.junit.Assert.assertArrayEquals;

public class RequestHandlerTest {
    private RequestHandler req;
    private Socket connection;

    @Before
    public void setup() {
        Socket connectionSocket = null;
        req = new RequestHandler(connectionSocket);
    }

    @Test
    public void splitString_문자열() {
        assertArrayEquals(new String[] {"localhost:8080", "/index.html"}, req.splitString("localhost:8080/index.html"));
    }
}
