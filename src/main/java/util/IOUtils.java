package util;

import model.User;

import java.io.*;
import java.nio.file.Files;

public class IOUtils {
    /**
     * @param BufferedReader는
     *            Request Body를 시작하는 시점이어야
     * @param contentLength는
     *            Request Header의 Content-Length 값이다.
     * @return
     * @throws IOException
     */
    public static String readData(BufferedReader br, int contentLength) throws IOException {
        char[] body = new char[contentLength];
        br.read(body, 0, contentLength);
        return String.copyValueOf(body);
    }

    public static byte[] fileData(String[] tokens) throws IOException {
        return Files.readAllBytes(new File("./webapp" + tokens[1]).toPath());
    }

    public static String firstlineData(InputStream in) throws IOException {
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        System.out.println("*39*" + line);
        return line;
    }

    public static void alllinePrint(InputStream in) throws IOException {
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        String line = null;

        while(!"".equals(line)) {
            line = br.readLine();
            System.out.println("*40*" + line);
            if(line == null) { return; }
        }
    }

    public static String[] splitString(String line) {
        String[] tokens = line.split(" ");
        return tokens;
    }

    public static String[] urlParse(String line) {
        String[] temp = HttpRequestUtils.parseQueryString(line).values().toArray(new String[0]);
        return temp;
    }

    public static User userInto(String[] getUser) {
        User userObject = new User(getUser[2], getUser[0], getUser[1], splitString(getUser[3])[0]);
        return userObject;
    }
}
