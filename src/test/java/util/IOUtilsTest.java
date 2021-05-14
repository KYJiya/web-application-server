package util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import model.User;
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

    @Test
    public void urlParse를_검사한다() throws Exception {
        String Get = "GET /user/create?userId=sight&password=fd1&name=yongjun&email=yjkwon%40futuremain.com HTTP/1.1";

//        logger.debug("parse body : {}", Arrays.toString(IOUtils.urlParse(Get)));
        assertArrayEquals(new String[] {"fd1", "yongjun", "sight", "yjkwon%40futuremain.com HTTP/1.1"}, IOUtils.urlParse(Get));
    }

    @Test
    public void userInto를_검사한다() throws Exception {
        String[] getUser = {"fd1", "yongjun", "sight", "yjkwon%40futuremain.com"};

//        logger.debug("parse body : {}", IOUtils.userInto(getUser));
//        똑같은데 다르다는 에러 발생
//        C:\Users\Yongjun\AppData\Local\JetBrains\Toolbox\apps\IDEA-C\ch-0\211.7142.45\jbr\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:C:\Users\Yongjun\AppData\Local\JetBrains\Toolbox\apps\IDEA-C\ch-0\211.7142.45\lib\idea_rt.jar=55860:C:\Users\Yongjun\AppData\Local\JetBrains\Toolbox\apps\IDEA-C\ch-0\211.7142.45\bin -Dfile.encoding=UTF-8 -classpath "C:\Users\Yongjun\AppData\Local\JetBrains\Toolbox\apps\IDEA-C\ch-0\211.7142.45\lib\idea_rt.jar;C:\Users\Yongjun\AppData\Local\JetBrains\Toolbox\apps\IDEA-C\ch-0\211.7142.45\plugins\junit\lib\junit5-rt.jar;C:\Users\Yongjun\AppData\Local\JetBrains\Toolbox\apps\IDEA-C\ch-0\211.7142.45\plugins\junit\lib\junit-rt.jar;D:\yongjun\programming project\java\Onion\web-application-server\target\test-classes;D:\yongjun\programming project\java\Onion\web-application-server\target\classes;C:\Users\Yongjun\.m2\repository\junit\junit\4.11\junit-4.11.jar;C:\Users\Yongjun\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;C:\Users\Yongjun\.m2\repository\com\google\guava\guava\18.0\guava-18.0.jar;C:\Users\Yongjun\.m2\repository\ch\qos\logback\logback-classic\1.1.2\logback-classic-1.1.2.jar;C:\Users\Yongjun\.m2\repository\ch\qos\logback\logback-core\1.1.2\logback-core-1.1.2.jar;C:\Users\Yongjun\.m2\repository\org\slf4j\slf4j-api\1.7.6\slf4j-api-1.7.6.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 util.IOUtilsTest,userInto를_검사한다
//        17:04:05,397 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.groovy]
//        17:04:05,398 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback-test.xml]
//        17:04:05,398 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Found resource [logback.xml] at [file:/D:/yongjun/programming%20project/java/Onion/web-application-server/target/classes/logback.xml]
//        17:04:05,507 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - debug attribute not set
//        17:04:05,518 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - About to instantiate appender of type [ch.qos.logback.core.ConsoleAppender]
//        17:04:05,526 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - Naming appender as [STDOUT]
//        17:04:05,618 |-WARN in ch.qos.logback.core.ConsoleAppender[STDOUT] - This appender no longer admits a layout as a sub-component, set an encoder instead.
//        17:04:05,618 |-WARN in ch.qos.logback.core.ConsoleAppender[STDOUT] - To ensure compatibility, wrapping your layout in LayoutWrappingEncoder.
//        17:04:05,618 |-WARN in ch.qos.logback.core.ConsoleAppender[STDOUT] - See also http://logback.qos.ch/codes.html#layoutInsteadOfEncoder for details
//        17:04:05,618 |-INFO in ch.qos.logback.classic.joran.action.RootLoggerAction - Setting level of ROOT logger to DEBUG
//        17:04:05,618 |-INFO in ch.qos.logback.core.joran.action.AppenderRefAction - Attaching appender named [STDOUT] to Logger[ROOT]
//        17:04:05,619 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - End of configuration.
//        17:04:05,620 |-INFO in ch.qos.logback.classic.joran.JoranConfigurator@815b41f - Registering current configuration as safe fallback point
//
//
//        java.lang.AssertionError: expected: model.User<User [userId=sight, password=fd1, name=yongjun, email=yjkwon%40futuremain.com]> but was: model.User<User [userId=sight, password=fd1, name=yongjun, email=yjkwon%40futuremain.com]>
//        Expected :model.User<User [userId=sight, password=fd1, name=yongjun, email=yjkwon%40futuremain.com]>
//        Actual   :model.User<User [userId=sight, password=fd1, name=yongjun, email=yjkwon%40futuremain.com]>
        assertEquals(new User("sight", "fd1", "yongjun", "yjkwon%40futuremain.com"), IOUtils.userInto(getUser));
    }
}
