package web;

import model.Parser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@WebServlet(description = "Starting page servlet", urlPatterns = "/home", loadOnStartup = 1)
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL url = new URL(req.getParameter("url"));
        List<String> list = Parser.read(url);
        list.forEach(System.out::println);
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/home.jsp");
        dispatcher.forward(req, resp);
    }
}
