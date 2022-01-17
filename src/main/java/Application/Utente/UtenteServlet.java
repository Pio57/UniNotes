package Application.Utente;

import Application.Corso.ServiceCorso.CorsoService;
import Application.Corso.ServiceCorso.CorsoServiceImpl;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoService;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoServiceImpl;
import Application.Utente.ServiceUtente.UtenteService;
import Application.Utente.ServiceUtente.UtenteServiceImpl;
import Storage.Corso.CorsoBean;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;
import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteDao;

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



//Manca lista preferiti

@WebServlet(name = "UtenteServlet", value = "/Utente/*")
public class UtenteServlet extends HttpServlet {

    private final UtenteService utenteService = new UtenteServiceImpl();
    private final CorsoService corsoService = new CorsoServiceImpl();
    private final MaterialeDidatticoService materialeService = new MaterialeDidatticoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";

        switch (path){
            case "/home":{

                UtenteBean u = (UtenteBean) request.getSession().getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/home.jsp").forward(request,response);
                break;
            }

            case "/dashboard":{
                UtenteBean u = (UtenteBean) request.getSession().getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }
                if(u.isTipo()){
                   ArrayList<MaterialeDidatticoBean> materiale = materialeService.visualizzaTutti();
                   request.setAttribute("totMateriale",materiale.size());
                    ArrayList<UtenteBean> utenti = utenteService.visualizzaUtenti();
                    request.setAttribute("totUtenti",utenti.size());
                    ArrayList<CorsoBean> corsi = corsoService.visualizzaCorsi();
                    request.setAttribute("totCorsi",corsi.size());
                }
                u.setMateriale(materialeService.visualizzaMaterialeDiUnUtente(u.getIdUtente()));
                request.getSession().setAttribute("utente",u);
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/dashboard/dashboard.jsp").forward(request,response);
                break;
            }

            case "/registrazione":{
                request.getRequestDispatcher("/registrazione.jsp").forward(request,response);
                break;
            }

            case "/login": {//login [adimn/studente]
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            }

            case "/visualizzaUtenti":{ //visualizza utenti registrati [adimn]

                UtenteBean u = (UtenteBean) request.getSession().getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }

                ArrayList<UtenteBean> utenti = new ArrayList<>();
                utenti = utenteService.visualizzaUtenti();;
                request.setAttribute("utenti", utenti);
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/dashboard/utenti.jsp").forward(request, response);
                break;
            }

            case "/visualizzaPaginaPersonale":{ //visualizza utenti registrati [adimn]
                //da implementare



                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/dashboard/paginaPersonale.jsp").forward(request, response);
                break;
            }

            case "/logout": {//logout [adimn/cliente]
                HttpSession session = request.getSession(false);
                session.removeAttribute("utente");
                session.invalidate();
                response.sendRedirect("/UniNotes_war_exploded/index.jsp");

                break;
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";

        switch (path){

            case "/registrazione":{ //login [adimn/studente/guest]

                UtenteBean u;

                String nomePattern = "[a-zA-Z\\s]+$";// pattern vecchio [A-Z a-z]
                String cognomePattern = "[a-zA-Z\\s]+$";// pattern vecchio [A-Z a-z]
                String cfPattern = "(^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$)"; // qui ho aggiunto delle patentesi in piu all'inizio e alla fine
                String emailPattern = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)"; //pattern vecchio ^[a-zA-Z0-9.!#$%&’*+/=?^_`{}~-]+@(?:[a-zA-Z0-9-]+\.)*$
                String dataPattern = ""; //rivedere
                String passwordPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\w{6,}$"; // pattern vecchio [A-Za-z0-9.]&


                String nome = request.getParameter("Nome");
                String cognome = request.getParameter("Cognome");
                String cf = request.getParameter("CF");
                String email = request.getParameter("Email");
                String password = request.getParameter("Password");
                String confermaPassword = request.getParameter("CPassword");
                String data = request.getParameter("DataDiNascita");

                if (nome.matches(nomePattern) && cognome.matches(cognomePattern) && cf.matches(cfPattern) && email.matches(emailPattern) && password.matches(passwordPattern) && confermaPassword.matches(passwordPattern) && password.equals(confermaPassword)) {

                    try {

                        u = utenteService.registrazione(nome, cognome, cf, email, password, data);
                        request.getSession(false).invalidate();
                        HttpSession ssn = request.getSession(true);
                        ssn.setAttribute("utente", u);
                        ssn.setMaxInactiveInterval(86400);

                    } catch (SQLException | NoSuchAlgorithmException throwables) {
                        throwables.printStackTrace();
                    }
                    response.sendRedirect("/UniNotes_war_exploded/Utente/home");
                }
                    break;
            }

            case "/login" : {

                UtenteBean utente = new UtenteBean();

                String emailPattern = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)"; //pattern vecchio ^[a-zA-Z0-9.!#$%&’*+/=?^_`{}~-]+@(?:[a-zA-Z0-9-]+\.)*$
                String passwordPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\w{6,}$"; // pattern vecchio [A-Za-z0-9.]&



                String email = request.getParameter("email");
                String password = request.getParameter("password");

               if (email.matches(emailPattern) && password.matches(passwordPattern)) {
                    utente.setEmail(email);
                try {
                    utente.setPassword(password);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                utente = utenteService.login(email, utente.getPassword());
                if(utente != null){
                    request.getSession(false).invalidate();
                    HttpSession ssn = request.getSession(true);
                    ssn.setAttribute("utente", utente);
                    ssn.setMaxInactiveInterval(86400);
                    response.sendRedirect("/UniNotes_war_exploded/Utente/home");
                }else{
                    response.sendRedirect("/UniNotes_war_exploded/");
                }


                }
                break;
            }

            case "/rendiAdmin" : { //modifica stato studente [adimn]


                UtenteBean u = new UtenteBean();
                UtenteDao ud = new UtenteDao();

                String idAccount = request.getParameter("cambio");

                if (idAccount != null) {
                    u = ud.doRetriveById(Integer.parseInt(idAccount));
                    utenteService.rendiAdmin(u);
                }
                response.sendRedirect("/UniNotes_war_exploded/Utente/visualizzaUtenti"); //NON so se è giusto

                break;
            }

            case "/modifica":{ //login [adimn/studente/guest]

                HttpSession ssn = request.getSession();

                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }


                String nomePattern = "[a-zA-Z\\s]+$";// pattern vecchio [A-Z a-z]
                String cognomePattern = "[a-zA-Z\\s]+$";// pattern vecchio [A-Z a-z]
                String cfPattern = "(^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$)"; // qui ho aggiunto delle patentesi in piu all'inizio e alla fine
                String emailPattern = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)"; //pattern vecchio ^[a-zA-Z0-9.!#$%&’*+/=?^_`{}~-]+@(?:[a-zA-Z0-9-]+\.)*$
                String dataPattern = ""; //rivedere
                String passwordPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\w{6,}$"; // pattern vecchio [A-Za-z0-9.]&


                String nome = request.getParameter("Nome");
                String cognome = request.getParameter("Cognome");
                String cf = request.getParameter("CF");
                String email = request.getParameter("Email");
                String data = request.getParameter("DataDiNascita");


                if (nome.matches(nomePattern) && cognome.matches(cognomePattern) && cf.matches(cfPattern) && email.matches(emailPattern)) {
                        u.setNome(nome);
                        u.setCognome(cognome);
                        u.setCf(cf);
                        u.setEmail(email);
                        u.setDdn(LocalDate.parse(data));
                        u = utenteService.aggiorna(u);
                        if(u != null){
                            ssn.setAttribute("utente", u);
                        }else{
                            //aggiungere pagina d'errore
                            break;
                        }

                    response.sendRedirect("/UniNotes_war_exploded/Utente/home");
                }
                break;
            }


        }
    }

}
