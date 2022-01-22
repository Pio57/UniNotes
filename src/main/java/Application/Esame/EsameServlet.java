package Application.Esame;

import Application.Esame.ServiceEsame.EsameService;
import Application.Esame.ServiceEsame.EsameServiceImpl;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


@WebServlet(name = "EsameServlet", value = "/Esame/*")
public class EsameServlet extends HttpServlet {

    private final EsameService esameService= new EsameServiceImpl();
    private final LibrettoService librettoService= new LibrettoServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/elimina":{
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                LibrettoBean l = (LibrettoBean) ssn.getAttribute("libretto");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }
                int id = Integer.parseInt(request.getParameter("id"));
                if(esameService.eliminaEsame(id)){
                    response.sendRedirect("/UniNotes_war_exploded/Libretto/visualizzaLibretto");
                    break;
                }
                response.sendRedirect("/UniNotes_war_exploded/Libretto/visualizzaLibretto");//pagina di errore
                break;

            }
            /*
            case "/modifica":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaEsame/modifica.jsp").forward(request,response);
                break;
            }*/
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        request.getSession().setAttribute("errors", null);
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

                ArrayList<String> errors = new ArrayList<>();


                if(!nome.matches(nomePattern)){
                    errors.add("Il nome non deve contenere numeri");
                }
                if(voto<18 || voto>31 ){//pio devi modificare il voto nella jsp con il voto lode
                    errors.add("Il voto non valido");
                }
                if(cfu<1 || cfu>12 ){
                    errors.add("Il cfu non valido");
                }
                if(!nomeProfessore.matches(nomePattern)){
                    errors.add("Il nome del professore non deve contenere numeri");
                }

                request.setAttribute("errors", errors);
                request.setAttribute("Nome",nome);
                request.setAttribute("Voto",voto);
                request.setAttribute("Cfu",cfu);
                request.setAttribute("NomeProfessore", nomeProfessore);



                if (nome.matches(nomePattern) && nomeProfessore.matches(nomePattern) && voto>=18 && voto<=31 && cfu>=1 && cfu<=12) {

                    l.aggiungiEsame(new EsameBean(nome,nomeProfessore,voto,cfu,data));
                    u.setLibretto(l);
                    esameService.inserisciEsame(nome,nomeProfessore,voto,cfu,data,l.getIdLibretto());
                    librettoService.modificaLibretto(l);
                    ssn.setAttribute("libretto",u);
                    ssn.setAttribute("utente",u);
                    response.sendRedirect("/UniNotes_war_exploded/Libretto/visualizzaLibretto");
                    break;
                }else{
                    ssn.setAttribute("errors",errors);
                    request.setAttribute("Nome",nome);
                    request.setAttribute("Voto",voto);
                    request.setAttribute("Cfu",cfu);
                    request.setAttribute("NomeProfessore", nomeProfessore);

                    response.sendRedirect("/UniNotes_war_exploded/Libretto/visualizzaLibretto");
                    break;
                }

            }
            /*
            case "/elimina":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/elimina.jsp").forward(request,response);
                break;
            }*/

            case "/modifica":{
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                LibrettoBean l = (LibrettoBean) ssn.getAttribute("libretto");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }


                String nomePattern = "[a-zA-Z\\s]+$";// pattern vecchio [A-Z a-z]
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("Nome");
                String nomeProfessore = request.getParameter("NomeProfessore");
                int cfu = Integer.parseInt(request.getParameter("Cfu"));
                float voto = Float.parseFloat(request.getParameter("Voto"));
                LocalDate data = LocalDate.parse(request.getParameter("Data"));

                ArrayList<String> errors = new ArrayList<>();


                if(!nome.matches(nomePattern)){
                    errors.add("Il nome non deve contenere numeri");
                }
                if(voto<18 || voto>31 ){//pio devi modificare il voto nella jsp con il voto lode
                    errors.add("Il voto non valido");
                }
                if(cfu<1 || cfu>12 ){
                    errors.add("Il cfu non valido");
                }
                if(!nomeProfessore.matches(nomePattern)){
                    errors.add("Il nome del professore non deve contenere numeri");
                }

                request.setAttribute("errors", errors);
                request.setAttribute("Nome",nome);
                request.setAttribute("Voto",voto);
                request.setAttribute("Cfu",cfu);
                request.setAttribute("NomeProfessore", nomeProfessore);



                if (nome.matches(nomePattern) && nomeProfessore.matches(nomePattern ) && voto>=18 && voto<=31 && cfu>=1 && cfu<=12) {
                    l.aggiungiEsame(new EsameBean(nome,nomeProfessore,voto,cfu,data));
                    u.setLibretto(l);
                    esameService.modificaEsame(id,nome,nomeProfessore,voto,cfu,data);
                    response.sendRedirect("/UniNotes_war_exploded/Libretto/visualizzaLibretto");
                    break;
                }else{
                    ssn.setAttribute("errors",errors);
                    request.setAttribute("Nome",nome);
                    request.setAttribute("Voto",voto);
                    request.setAttribute("Cfu",cfu);
                    request.setAttribute("NomeProfessore", nomeProfessore);

                    response.sendRedirect("/UniNotes_war_exploded/Libretto/visualizzaLibretto");
                    break;
                }
            }
/*
            case "/visualizza":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizza.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTutti":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizzaTutti.jsp").forward(request,response);
                break;
            }*/
            default:
                throw new RuntimeException("Unexpected value: " + path);
        }
    }

}