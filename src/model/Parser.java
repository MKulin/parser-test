package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс логики приложения. Использует фреймворк Jsoup для чтения, переданной html страницы.
 * @see org.jsoup.Jsoup
 */
public class Parser {

    /**
     * Метод получает в качестве параметра строку с интернет адресом html страницы.
     * После её "прочтения" получает объект типа org.jsoup.nodes.Document.
     * В единственном цикле метода происходит итерация по объектам
     * org.jsoup.nodes.Document из тега <body> типа org.jsoup.nodes.Element,
     * из которых выбираются объекты с тегом <a>.
     * Выбранные объекты заносятся в результирующий параметризированный по типу TableRow
     * список java.util.ArrayList.
     * В случае, если аргумент "url" не соответствует адресу существующей html страницы,
     * метод "выбрасывает" исключение WrongAddressException
     * @param url - строковый аргумент с адресом html страницы
     * @return - параметризированный по типу TableRow список java.util.ArrayList
     * @throws WrongAddressException - исключение d случае, если аргумент "url"
     *                                не соответствует адресу существующей html страницы
     */
    public static List<TableRow> read (String url) throws WrongAddressException {
        List<TableRow> result = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            int count = 1;
            for(Element el : doc.body().getElementsByTag("a"))
            {
                TableRow tr = new TableRow(count, el.text(), el.attr("href"));
                result.add(tr);
                count++;
            }
        } catch (Exception e) {
            throw new WrongAddressException("Проверьте корректность введенного адреса");
        }
        return result;
    }
}
