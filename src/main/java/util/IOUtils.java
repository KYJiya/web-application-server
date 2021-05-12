package util;

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

    public static byte[] lineData(InputStream in) throws IOException {
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        String[] tokens = line.split(" ");
        for(int i = 0; i < tokens.length; i++) {
            System.out.println(i+": "+tokens[i]);
        }
        return Files.readAllBytes(new File("./webapp" + tokens[1]).toPath());
//        while(!"".equals(line)) {
//            line = br.readLine();
//            System.out.println(line);
//            tokens = line.split(" ");
//            for(int i = 0; i < tokens.length; i++) {
//                System.out.println(i+": "+tokens[i]);
//            }
//            if(line == null) { return; }
//        }
//        while((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
    }

    public static String[] splitString(String line) {
        String[] tokens = line.split(" ");
        return tokens;
    }
}
