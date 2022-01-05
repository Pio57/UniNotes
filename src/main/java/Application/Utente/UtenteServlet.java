package Application.Utente;

import Application.Utente.ServiceUtente.UtenteService;
import Application.Utente.ServiceUtente.UtenteServiceImpl;
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
import java.util.ArrayList;



//Manca lista preferiti

@WebServlet(name = "UtenteServlet", value = "/Utente/*")
public class UtenteServlet extends HttpServlet {

    private final UtenteService utenteService = new UtenteServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/home":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/home.jsp").forward(request,response);
                break;
            }

            case "/dashboard":{
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
                ArrayList<UtenteBean> utenti = new ArrayList<>();
                try {
                    utenti = utenteService.visualizzaUtenti();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                request.setAttribute("utenti", utenti);
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/dashboard/utenti.jsp").forward(request, response);
                break;
            }

            case "/visualizzaPaginaPersonale":{ //visualizza utenti registrati [adimn]
                //da implementare
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/dashboard/paginaPersonale.jsp").forward(request, response);
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

                String nomePattern = "[A-Z a-z]$";
                String cognomePattern = "[A-Z a-z]$";
                String cfPattern = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$";
                String emailPattern = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{}~-]+@(?:[a-zA-Z0-9-]+\\.)*$";
                String dataPattern = ""; //rivedere
                String passwordPattern = "[A-Za-z0-9.]&";

                String nome = request.getParameter("Nome");
                String cognome = request.getParameter("Cognome");
                String cf = request.getParameter("CF");
                String email = request.getParameter("Email");
                String password = request.getParameter("Password");
                String confermaPassword = request.getParameter("ConfermaPassword");
                String data = request.getParameter("DataDiNascita");

                if (nome.matches(nomePattern) && cognome.matches(cognomePattern) && cf.matches(cfPattern) && email.matches(emailPattern) && password.matches(passwordPattern) && confermaPassword.matches(passwordPattern) && password.equals(confermaPassword)) {
                    System.out.println("Sono qui");
                    try {
                        u = utenteService.registrazione(nome, cognome, cf, email, password, data);
                        request.getSession(false).invalidate();
                        HttpSession ssn = request.getSession(true);
                        ssn.setAttribute("utente", u);
                        ssn.setMaxInactiveInterval(86400);

                    } catch (SQLException | NoSuchAlgorithmException throwables) {
                        throwables.printStackTrace();
                    }
                    System.out.println("Sono q");
                    response.sendRedirect("/UniNotes_war_exploded/Utente/home");
                }
                    break;
            }

            case "/login" : {

                UtenteBean utente = new UtenteBean();

                //String emailPattern = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{}~-]+@(?:[a-zA-Z0-9-]+\\.)*$";
               // String passwordPattern = "[A-Za-z0-9.] ";

                String email = request.getParameter("email");
                String password = request.getParameter("password");

               // if (email.matches(emailPattern) && password.matches(passwordPattern)) {
                    utente.setEmail(request.getParameter("email"));
                try {
                    utente.setPassword(request.getParameter("password"));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                utente = utenteService.login(email, password);
                    request.getSession(false).invalidate();
                    HttpSession ssn = request.getSession(true);
                    ssn.setAttribute("utente", utente);
                    ssn.setMaxInactiveInterval(86400);
                    response.sendRedirect("/UniNotes_war_exploded/Utente/home");
               // }
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


        }
    }

}
