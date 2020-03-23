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

@WebServlet("/wyswietl")
public class PrzepisController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("btn");
            PrzepisDao przepisDao = new PrzepisDao();
            List<Przepis> przepisy = new ArrayList<>();
            przepisy=przepisDao.readAll();
            przepisDao.close();
            Przepis przepis = new Przepis();
            for(Przepis p:przepisy){
                if(p.getID()==Integer.valueOf(action)){
                    przepis=p;
                    break;
                }
            }
            request.setAttribute("przepis", przepis);
            request.getRequestDispatcher("przepis.jsp").forward(request, response);

        }catch (Exception e){

        }
    }

}
