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

@WebServlet("/Filtr")
public class FiltrController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            System.out.println("Request to /sklep received ");
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            String rodzaj = request.getParameter("rodzaj");
            PrzepisDao przepisDao = new PrzepisDao();
            List<Przepis> przepisy = new ArrayList<>();
            if ("Wszystkie".equals(rodzaj)) {
                przepisy=przepisDao.readAllBy("name",action);
            } else if ("Zupy".equals(rodzaj)) {
                przepisy=przepisDao.readBy("zupa","name",action);
            } else if ("Dania".equals(rodzaj)) {
                przepisy=przepisDao.readBy("danie główne","name",action);
            }else if ("Przystawki".equals(rodzaj)) {
                przepisy=przepisDao.readBy("przystawka","name",action);
            }else if ("Desery".equals(rodzaj)) {
                przepisy=przepisDao.readBy("deser","name",action);
            }
            przepisDao.close();
            request.setAttribute("akcja", rodzaj);
            request.setAttribute("przepisy", przepisy);
            request.getRequestDispatcher("przepisy.jsp").forward(request, response);

        }catch (Exception e){

        }
    }

}
