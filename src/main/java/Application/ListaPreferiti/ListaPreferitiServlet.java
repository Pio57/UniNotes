package Application.ListaPreferiti;

import Application.Corso.ServiceCorso.CorsoService;
import Application.Corso.ServiceCorso.CorsoServiceImpl;
import Application.ListaPreferiti.ServiceListaPreferiti.ListaPreferitiImpl;
import Application.ListaPreferiti.ServiceListaPreferiti.ListaPreferitiService;
import Storage.Corso.CorsoBean;
import Storage.Utente.UtenteBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListaPreferitiServlet", value = "/ListaPreferiti/*")
public class ListaPreferitiServlet extends HttpServlet {

    private final CorsoService corsoService = new CorsoServiceImpl();
    private final ListaPreferitiService listaPreferitiService = new ListaPreferitiImpl();

    /**
     * Metodo doGet della servlet Lista Preferiti
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){

            /**
             *  Caso per inserire e rimuovere da lista preferiti
             */
            case "/toggle":{
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }

                int idCorso = Integer.parseInt(request.getParameter("idCorso"));
                boolean appartiene = false;
                for(CorsoBean c : listaPreferitiService.visualizzaListaUtente(u.getIdUtente()).getCorsi()){
                    if(c.getId() == idCorso){
                        appartiene = true;
                    }
                }

                if(appartiene){
                    listaPreferitiService.rimuoviDaListaPreferiti(u.getIdUtente(),idCorso);
                }else{
                    listaPreferitiService.inserisciInListaPreferiti(u.getIdUtente(),idCorso);
                    /*
                    CorsoBean c = corsoService.visualizzaCorso(idCorso);
                    u.setListaPreferiti(listaPreferitiService.visualizzaListaUtente(u.getIdUtente()));


                     */
                }

                request.setAttribute("listaPreferitiID",listaPreferitiService.idCorsi(u.getIdUtente()));
                request.setAttribute("listaPreferiti",listaPreferitiService.visualizzaListaUtente(u.getIdUtente()));
                request.setAttribute("corsi",corsoService.visualizzaCorsi());
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizzaTutti.jsp").forward(request,response);
                break;
            }

            /**
             *  Caso per liualizzare la lista preferiti
             */
            case "/visualizza":{
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }

                request.setAttribute("listaPreferiti",listaPreferitiService.visualizzaListaUtente(u.getIdUtente()));
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaListaPreferiti/visualizzaListaPreferiti.jsp").forward(request,response);
                break;
            }

            /**
             *  Caso per rimuovere da lista preferiti
             */
            case "/rimuoviDallaFavoriteList":{
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }


                int idCorso = Integer.parseInt(request.getParameter("idCorso"));
                for(CorsoBean c : listaPreferitiService.visualizzaListaUtente(u.getIdUtente()).getCorsi()){
                    if(c.getId() == idCorso){
                        listaPreferitiService.rimuoviDaListaPreferiti(u.getIdUtente(),idCorso);
                    }
                }

                request.setAttribute("listaPreferiti",listaPreferitiService.visualizzaListaUtente(u.getIdUtente()));
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaListaPreferiti/visualizzaListaPreferiti.jsp").forward(request,response);
                break;
            }
            default:
                throw new RuntimeException("Unexpected value: " + path);

        }
    }

    /**
     * Metodo doPost della servlet ListaPreferiti
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
