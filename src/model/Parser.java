package model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static Pattern pattern = Pattern.compile("\\s*(?i)href\\s*=\\s*(\"http+s?([^\"]*\")|'[^']*'|([^'\">\\s]+))");

    private static List<String> hrefs(String page){
        Matcher m = pattern.matcher(page);
        List<String> result = new ArrayList<>();
        while (m.find()){
            result.add(m.group());
        }
        return result;
    }

    public static List<String> read(URL url){
        String s = null;
        try {
            InputStream in = url.openStream();
            byte[] buffer = new byte[in.available()];
            int read;
            while ((read = in.read()) > -1){
                read = in.read(buffer);
            }
            s = new String(buffer, 0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hrefs(s);
    }
}
