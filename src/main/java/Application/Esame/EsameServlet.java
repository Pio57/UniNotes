package Application.Esame;

import Application.Esame.ServiceEsame.EsameService;
import Application.Esame.ServiceEsame.EsameServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet(name = "EsameServlet", value = "/Esame/*")
public class EsameServlet extends HttpServlet {

    private final EsameService esameService= new EsameServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/crea":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaEsame/crea.jsp").forward(request,response);
                break;
            }
            case "/elimina":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaEsame/elimina.jsp").forward(request,response);
                break;
            }
            case "/modifica":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaEsame/modifica.jsp").forward(request,response);
                break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/crea":{
                String nome = request.getParameter("nome");
                String nomeProfessore = request.getParameter("nomeProfessore");
                int cfu=Integer.parseInt(request.getParameter("cfu"));
                float voto= Float.parseFloat(request.getParameter("voto"));
                //Date data = LocalDate.parse(request.getParameter("dataEsame"));
                Date data=new Date();
                esameService.inserisciEsame(nome,nomeProfessore,voto,cfu,data);
                response.sendRedirect("index.jsp");
                break;
            }
            case "/elimina":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/elimina.jsp").forward(request,response);
                break;
            }
            case "/modifica":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/modifica.jsp").forward(request,response);
                break;
            }
            case "/visualizza":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizza.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTutti":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizzaTutti.jsp").forward(request,response);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + path);
        }
    }

}