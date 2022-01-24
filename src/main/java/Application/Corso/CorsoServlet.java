package Application.Corso;

import Application.Corso.ServiceCorso.CorsoService;
import Application.Corso.ServiceCorso.CorsoServiceImpl;
import Application.ListaPreferiti.ServiceListaPreferiti.ListaPreferitiImpl;
import Application.ListaPreferiti.ServiceListaPreferiti.ListaPreferitiService;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoService;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoServiceImpl;
import Application.Utente.ServiceUtente.UtenteService;
import Application.Utente.ServiceUtente.UtenteServiceImpl;
import Storage.Corso.CorsoBean;
import Storage.Libretto.LibrettoBean;
import Storage.ListaPreferiti.ListaPreferitiBean;
import Storage.ListaPreferiti.ListaPreferitiDao;
import Storage.Utente.UtenteBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "CorsoServlet", value = "/Corso/*")
public class CorsoServlet extends HttpServlet {

    private final UtenteService utenteService = new UtenteServiceImpl();
    private final CorsoService corsoService = new CorsoServiceImpl();
    private final MaterialeDidatticoService materialeDidattico = new MaterialeDidatticoServiceImpl();
    private final ListaPreferitiService listaPreferitiService = new ListaPreferitiImpl();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/crea":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/crea.jsp").forward(request,response);
                break;
            }
            case "/elimina":{
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }
                int id = Integer.parseInt(request.getParameter("id"));
                if(corsoService.eliminaCorso(id)){
                    response.sendRedirect("/UniNotes_war_exploded/Corso/visualizzaTutti");
                    break;
                }
                response.sendRedirect("/UniNotes_war_exploded/Libretto/visualizzaLibretto");//pagina di errore
                break;

            }
            case "/modifica":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/modifica.jsp").forward(request,response);
                break;
            }
            case "/visualizza":{
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }
                int id = Integer.parseInt(request.getParameter("idCorso"));
                //int id = Integer.parseInt(request.getParameter("idCorso"));
                CorsoBean c = corsoService.visualizzaCorso(id);
                c.setListaMateriale(materialeDidattico.visualizzaMaterialeDiUnCorso(id));
                request.setAttribute("Corso",c);
                request.setAttribute("Materiale",materialeDidattico.visualizzaMaterialeDiUnCorso(id));
                //togliere l'id statico --> mettendone uno dinamico
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizza.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTutti":{//admin

                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }

                ArrayList<CorsoBean> c = corsoService.visualizzaCorsi();
                for(CorsoBean corso : c){
                    corso.setListaMateriale(materialeDidattico.visualizzaMaterialeDiUnCorso(corso.getId()));
                }
                request.setAttribute("corsi",c);
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/dashboard/corsi.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTuttiUtente":{//utente

                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }

                request.setAttribute("listaPreferitiID",listaPreferitiService.idCorsi(u.getIdUtente()));
                request.setAttribute("listaPreferiti",listaPreferitiService.visualizzaListaUtente(u.getIdUtente()));
                request.setAttribute("corsi",corsoService.visualizzaCorsi());
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizzaTutti.jsp").forward(request,response);
                break;
            }

            /* si potrbbe eliminare
            case "/aggiungiAPreferiti":{

                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }

                int idCorso = Integer.parseInt(request.getParameter("idCorso"));
                CorsoBean c = corsoService.visualizzaCorso(idCorso);
                utenteService.interireInListaPreferiti(u.getIdUtente(),idCorso);
                request.setAttribute("corsi",corsoService.visualizzaCorsi());
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizzaTutti.jsp").forward(request,response);
                break;
            }

             */
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        request.getSession().setAttribute("errors", null);
        switch (path){
            case "/crea":{
                UtenteBean u = (UtenteBean) request.getSession().getAttribute("utente");
                HttpSession ssn = request.getSession();
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }

                CorsoBean c;

                String nomePattern = "[a-zA-Z\\s]+$";// pattern vecchio [A-Z a-z]


                String nome = request.getParameter("Nome");
                String descrizione = request.getParameter("Descrizione");
                String nomeProfessore = request.getParameter("NomeProfessore");

                ArrayList<String> errors = new ArrayList<>();


                if(!nome.matches(nomePattern)){
                    errors.add("Il nome non deve contenere numeri");
                }
                if(!descrizione.matches(nomePattern) ){
                    errors.add("Il descrizione non deve contenere numeri");
                }
                if(!nomeProfessore.matches(nomePattern)){
                    errors.add("Il nome del professore non deve contenere numeri");
                }

                    request.setAttribute("errors", errors);
                    request.setAttribute("Nome",nome);
                    request.setAttribute("Descrizione", descrizione);
                    request.setAttribute("NomeProfessore", nomeProfessore);

                if (nome.matches(nomePattern) && descrizione.matches(nomePattern) && nomeProfessore.matches(nomePattern)) {

                    c = corsoService.inserisciCorso(nome,descrizione,nomeProfessore);

                    response.sendRedirect("/UniNotes_war_exploded/Corso/visualizzaTutti");
                    break;

                }else {
                    ssn.setAttribute("errors", errors);
                    request.setAttribute("Nome",nome);
                    request.setAttribute("Descrizione", descrizione);
                    request.setAttribute("NomeProfessore", nomeProfessore);

                    response.sendRedirect("/UniNotes_war_exploded/Corso/visualizzaTutti");
                    break;
                }
            }
            /*
            case "/elimina":{
                String id = request.getParameter("id");
                corsoService.eliminaCorso(Integer.parseInt(id));
                request.getRequestDispatcher("/UniNotes_war_exploded/").forward(request,response);
                break;
            }*/

            case "/modifica":{
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) request.getSession().getAttribute("utente");

                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }

                CorsoBean c;

                String nomePattern = "[a-zA-Z\\s]+$";

                String id = request.getParameter("id");
                String nome = request.getParameter("Nome");
                String descrizione = request.getParameter("Descrizione");
                String nomeProfessore = request.getParameter("NomeProfessore");

                ArrayList<String> errors = new ArrayList<>();

                if(!nome.matches(nomePattern)){
                    errors.add("Il nome non deve contenere numeri");
                }
                if(!descrizione.matches(nomePattern) ){
                    errors.add("Il descrizione non deve contenere numeri");
                }
                if(!nomeProfessore.matches(nomePattern)){
                    errors.add("Il nome del professore non deve contenere numeri");
                }

                if (nome.matches(nomePattern) && descrizione.matches(nomePattern) && nomeProfessore.matches(nomePattern)) {
                    c = corsoService.modificaCorso(Integer.parseInt(id),nome,descrizione,nomeProfessore);
                    response.sendRedirect("/UniNotes_war_exploded/Corso/visualizzaTutti");
                    break;
                }else{
                    ssn.setAttribute("errors", errors);
                    request.setAttribute("Nome",nome);
                    request.setAttribute("Descrizione", descrizione);
                    request.setAttribute("NomeProfessore", nomeProfessore);
                    response.sendRedirect("/UniNotes_war_exploded/Corso/visualizzaTutti");
                    break;

                }


            }

            case "/visualizza":{//questo richiama doget per quanto riguarda gli errori
                doGet(request,response);
                break;
            }
            /*
            case "/visualizzaTutti":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizzaTutti.jsp").forward(request,response);
                break;
            }*/
        }
    }

}
