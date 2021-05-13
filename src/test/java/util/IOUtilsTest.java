package util;

import java.io.*;
import java.nio.charset.StandardCharsets;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
    public void splitString을_검사한다() {
        String line = "GET /index.html";

        logger.debug("parse body : {}", IOUtils.splitString(line));
        assertArrayEquals(new String[] {"GET", "/index.html"}, IOUtils.splitString(line));
    }

    @Test
    public void firstlineData를_검사한다() throws Exception {
        String filePath = "D:\\yongjun\\programming project\\java\\Onion\\web-application-server\\src\\test\\java\\util\\test.txt";
        InputStream in = new FileInputStream(filePath);

        assertEquals("test string", IOUtils.firstlineData(in));
    }
}
