package Application.Libretto;

import Application.Libretto.ServiceLibretto.LibrettoService;
import Application.Libretto.ServiceLibretto.LibrettoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LibrettoServlet", value = "/Libretto/*")
public class LibrettoServlet extends HttpServlet {

    private final LibrettoService librettoService= new LibrettoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/visualizzaLibretto":{//ho modificato questa classe per fare una prova
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/dashboard/prova.jsp").forward(request,response);
                break;
                /*
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaLibretto/visualizzaLibretto").forward(request,response);
                break;

                 */
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){

            case "/visualizzaLibretto":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizza.jsp").forward(request,response);
                break;
            }
        }
    }



}