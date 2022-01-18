package Application.Esame;

import Application.Esame.ServiceEsame.EsameService;
import Application.Esame.ServiceEsame.EsameServiceImpl;
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
import java.time.LocalDate;
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

                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                LibrettoBean l = (LibrettoBean) ssn.getAttribute("libretto");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }


                String nomePattern = "[a-zA-Z\\s]+$";// pattern vecchio [A-Z a-z]

                String nome = request.getParameter("Nome");
                String nomeProfessore = request.getParameter("NomeProfessore");
                int cfu = Integer.parseInt(request.getParameter("Cfu"));
                float voto = Float.parseFloat(request.getParameter("Voto"));
                LocalDate data = LocalDate.parse(request.getParameter("Data"));

                if (nome.matches(nomePattern) && nomeProfessore.matches(nomePattern)) {

                    l.aggiungiEsame(new EsameBean(nome,nomeProfessore,voto,cfu,data));
                    u.setLibretto(l);
                    esameService.inserisciEsame(nome,nomeProfessore,voto,cfu,data,l.getIdLibretto());
                    response.sendRedirect("/UniNotes_war_exploded/Libretto/visualizzaLibretto");
                }
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