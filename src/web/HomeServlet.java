package web;

import model.Parser;
import model.TableRow;
import model.WrongAddressException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Единственный, он же стартовый, сервлет приложения
 */
@WebServlet(description = "Parser home page", urlPatterns = "/home", loadOnStartup = 1)
public class HomeServlet extends HttpServlet {
    /**
     * Метод обработки запроса клиента.
     * После отправки запроса с параметром адреса html страницы, метод вызывает
     * статический метод model.Parser.read(String url) с параметром адреса html страницы и получает
     * параметризированный по типу model.TableRow список java.util.List.
     * Полученный список заносит в параметры javax.servlet.http.HttpServletRequest и
     * при помощи javax.servlet.RequestDispatcher перенаправляет параметризированный
     * списком HttpServletRequest назад на home.jsp
     * Если метод model.Parser.read(String url) завершается с WrongAddressException,
     * в HttpServletRequest добавляется параметр с сообщением о не корректном вводе адреса,
     * результирующий же список остается со значением null.
     * @param req - объект javax.servlet.http.HttpServletRequest, полученный от клиента
     * @param resp - объект javax.servlet.http.HttpServletResponse, созданный сервлет-контейнером
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        List<TableRow> list = null;
        try {
            list = Parser.read(url);
        } catch (WrongAddressException e) {
            req.setAttribute("exception", e.getMessage());
        }
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/home.jsp");
        dispatcher.forward(req, resp);
    }
}
