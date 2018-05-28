package web;

import model.Parser;
import model.TableRow;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(description = "Parser home page", urlPatterns = "/home", loadOnStartup = 1)
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        List<TableRow> list = Parser.read(url);
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/home.jsp");
        dispatcher.forward(req, resp);
    }
}
