package Application.Libretto;

import Application.Libretto.ServiceLibretto.LibrettoService;
import Application.Libretto.ServiceLibretto.LibrettoServiceImpl;
import Storage.Esame.EsameBean;
import Storage.Libretto.LibrettoBean;
import Storage.Utente.UtenteBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(name = "LibrettoServlet", value = "/Libretto/*")
public class LibrettoServlet extends HttpServlet {

    private final LibrettoService librettoService= new LibrettoServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/visualizzaLibretto":{//ho modificato questa classe per fare una prova
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }

                LibrettoBean l = librettoService.visualizzaLibretto(u.getLibretto().getIdLibretto());
                u.setLibretto(l);
                ssn.setAttribute("libretto",u.getLibretto());
                ssn.setAttribute("utente",u);
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaLibretto/visualizzaLibretto.jsp").forward(request,response);
                break;
            }
            default:
                throw new RuntimeException("Unexpected value: " + path);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){

            case "/visualizzaLibretto":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizza.jsp").forward(request,response);
                break;
            }
            default:
                throw new RuntimeException("Unexpected value: " + path);
        }

    }



}