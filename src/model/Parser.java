package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    /*private static Pattern pattern = Pattern.compile("\\s*(?i)href\\s*=\\s*(\"http+s?([^\"]*\")|'[^']*'|([^'\">\\s]+))");

    private static List<TableRow> hrefs(String page){
        Matcher m = pattern.matcher(page);
        List<TableRow> result = new ArrayList<>();
        int count = 1;
        while (m.find()){
            String href = m.group();
            TableRow tr = new TableRow(count, "name", href.substring(href.indexOf('"') + 1, href.lastIndexOf('"')));
            result.add(tr);
            count++;
        }
        return result;
    }

    public static List<TableRow> read(URL url){
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
    }*/

    public static List<TableRow> read (String url){
        List<TableRow> result = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            int count = 1;
            for(Element el : doc.getElementsByTag("a"))
            {
                TableRow tr = new TableRow(count, el.text(), el.attr("href"));
                result.add(tr);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
