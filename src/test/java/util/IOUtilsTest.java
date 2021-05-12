package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertArrayEquals;

public class IOUtilsTest {
    private static final Logger logger = LoggerFactory.getLogger(IOUtilsTest.class);

    @Test
    public void readData() throws Exception {
        String data = "abcd123";
        StringReader sr = new StringReader(data);
        BufferedReader br = new BufferedReader(sr);

        logger.debug("parse body : {}", IOUtils.readData(br, data.length()));
    }

    @Test
    public void splitString() throws Exception {
        String data = "localhost:8080 /index.html";
        StringReader sr = new StringReader(data);
        BufferedReader br = new BufferedReader(sr);
        String line = br.readLine();

        logger.debug("parse body : {}", IOUtils.splitString(line));
        assertArrayEquals(new String[] {"localhost:8080", "/index.html"}, IOUtils.splitString(line));
    }
}
