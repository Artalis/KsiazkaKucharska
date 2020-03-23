package ale.kod.controller;

import ale.kod.model.Przepis;
import ale.kod.model.PrzepisDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Meals")
public class ReadingControler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("gram");
            System.out.println("Request to /sklep received ");
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            PrzepisDao przepisDao = new PrzepisDao();
            List<Przepis> przepisy = new ArrayList<>();
            if ("Wszystkie dania".equals(action)) {
                przepisy=przepisDao.readAll();
            } else if ("Zupy".equals(action)) {
                przepisy=przepisDao.read("zupa");
            } else if ("Dania Główne".equals(action)) {
                przepisy=przepisDao.read("danie główne");
            }else if ("Przystawki".equals(action)) {
                przepisy=przepisDao.read("przystawka");
            }else if ("Desery".equals(action)) {
                przepisy=przepisDao.read("deser");
            }
            przepisDao.close();
            System.out.println(przepisy.size());
            request.setAttribute("przepisy", przepisy);
            request.setAttribute("akcja", action);
            request.getRequestDispatcher("przepisy.jsp").forward(request, response);

        }catch (Exception e){

        }
    }
}
