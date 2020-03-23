package ale.kod.controller;

import ale.kod.model.Przepis;
import ale.kod.model.PrzepisDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.IllegalFormatException;

@WebServlet("/Adding")
public class CookBookController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Przepis przepis = new Przepis();
try {
    System.out.println("Request to /sklep received ");
    request.setCharacterEncoding("UTF-8");
    przepis.setName(request.getParameter("nazwa"));
    przepis.setRodzaj(request.getParameter("rodzaj"));
    przepis.setUrl(request.getParameter("zdjecie"));
    przepis.setCzas(Integer.parseInt(request.getParameter("czas")));
    przepis.setTresc(request.getParameter("tresc"));
    request.setAttribute("przepis", przepis);

    if(przepis.trescPrzekraczaZakres()){
        throw  new NumberFormatException();
    }
    if (przepis.haveAll()) {
        PrzepisDao przepisDao =new PrzepisDao();
        przepisDao.save(przepis);
        przepisDao.close();
        request.getRequestDispatcher("dodano.jsp").forward(request, response);
    } else
        request.getRequestDispatcher("nieudany.jsp").forward(request, response);
}catch (NumberFormatException e){
    request.getRequestDispatcher("nieudany.jsp").forward(request, response);
}
    }

}
