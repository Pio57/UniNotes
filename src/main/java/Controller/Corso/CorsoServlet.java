package Controller.Corso;

import Controller.Corso.ServiceCorso.CorsoService;
import Controller.Corso.ServiceCorso.CorsoServiceImpl;
import Model.Corso.CorsoBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CorsoServlet", value = "/Corso/*")
public class CorsoServlet extends HttpServlet {

    private final CorsoService corsoService = new CorsoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/crea":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/crea.jsp").forward(request,response);
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
                CorsoBean c = corsoService.visualizzaCorso(2);
                request.setAttribute("Corso",c);//togliere l'id statico --> mettendone uno dinamico
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizza.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTutti":{
                ArrayList<CorsoBean> c = corsoService.visualizzaCorsi();
                request.setAttribute("corsi",corsoService.visualizzaCorsi());
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/dashboard/corsi.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTuttiUtente":{
                request.setAttribute("corsi",corsoService.visualizzaCorsi());
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizzaTutti.jsp").forward(request,response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/crea":{
                String nome = request.getParameter("Nome");
                String descrizione = request.getParameter("Descrizione");
                String nomeProfessore = request.getParameter("NomeProfessore");
                corsoService.inserisciCorso(nome,descrizione,nomeProfessore);
                response.sendRedirect("/UniNotes_war_exploded/");
                break;
            }
            case "/elimina":{
                String id = request.getParameter("id");
                corsoService.eliminaCorso(Integer.parseInt(id));
                request.getRequestDispatcher("/UniNotes_war_exploded/").forward(request,response);
                break;
            }
            case "/modifica":{
                String id = request.getParameter("idCorso");
                String nome = request.getParameter("Nome");
                String descrizione = request.getParameter("Descrizione");
                String nomeProfessore = request.getParameter("NomeProfessore");
                corsoService.modificaCorso(Integer.parseInt(id),nome,descrizione,nomeProfessore);
                response.sendRedirect("/UniNotes_war_exploded/");
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
        }
    }

}
