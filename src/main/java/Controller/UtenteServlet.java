package Controller;

import Model.Corso.CorsoBean;
import Model.Corso.CorsoDao;
import Model.ListaPreferiti.ListaPreferitiBean;
import Model.ListaPreferiti.ListaPreferitiDao;
import Model.Utente.UtenteBean;
import Model.Utente.UtenteDao;

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


//Manca lista preferiti

@WebServlet(name = "UtenteServlet", value = "/Utente/*")
public class UtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/registrazione":{
                request.getRequestDispatcher("/registrazione.jsp").forward(request,response);
                break;
            }

            case "/login": {//login [adimn/studente]
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                break;
            }

            case "/visualizzaUtenti":{ //visualizza utenti registrati [adimn]
                ArrayList<UtenteBean> utenti = new ArrayList<>();
                try {
                    utenti = visualizzaUtenti();
                    request.setAttribute("utenti", utenti);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/tuttiUtenti.jsp").forward(request, response);
                break;
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){

            case "/registrazione":{ //login [adimn/studente/guest]

                String nomePattern = "[A-Z a-z]";
                String cognomePattern = "[A-Z a-z]";
                String cfPattern = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$";
                String emailPattern = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{}~-]+@(?:[a-zA-Z0-9-]+\\.)*$";
                String dataPattern = "";
                String passwordPattern = "[A-Za-z0-9.] ";

                String nome = request.getParameter("Nome");
                String cognome = request.getParameter("Cognome");
                String cf = request.getParameter("CF");
                String email = request.getParameter("Email");
                String password = request.getParameter("Password");
                String confermaPassword = request.getParameter("ConfermaPassword");
                String data = request.getParameter("DataDiNascita");

                if (nome.matches(nomePattern) && cognome.matches(cognomePattern) && cf.matches(cfPattern) && email.matches(emailPattern) && password.matches(passwordPattern) && confermaPassword.matches(passwordPattern) && password.equals(confermaPassword) && data.matches(dataPattern)) {
                    try {
                        registrazione(nome, cognome, cf, email, password, data);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    response.sendRedirect("/UniNotes_war_exploded/Home/");
                }
                    break;
            }

            case "/login" : {

                UtenteBean utente = new UtenteBean();

                String emailPattern = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{}~-]+@(?:[a-zA-Z0-9-]+\\.)*$";
                String passwordPattern = "[A-Za-z0-9.] ";

                String email = request.getParameter("email");
                String password = request.getParameter("password");

                if (email.matches(emailPattern) && password.matches(passwordPattern)) {
                    utente.setEmail(request.getParameter("email"));
                    utente.setPassword(request.getParameter("password"));
                    utente = login(email, password);
                    response.sendRedirect("/UniNotes_war_exploded/Home/");
                }

            }

            case "/rendiAdmin" : { //modifica stato studente [adimn]

                UtenteBean u = new UtenteBean();
                UtenteDao ud = new UtenteDao();

                String idAccount = request.getParameter("cambio");

                if (idAccount != null) {
                    u = ud.doRetriveById(Integer.parseInt(idAccount));
                    rendiAdmin(u);
                }
                response.sendRedirect("/UniNotes_war_exploded/Utente/visualizzaUtenti"); //NON so se è giusto

                break;
            }


        }
    }

    private void registrazione(String nome, String cognome, String cf, String email, String password, String data) throws SQLException {
        UtenteBean utente = new UtenteBean();
        UtenteDao ud = new UtenteDao();

        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setCognome(cf);
        utente.setEmail(email);
        utente.setPassword(password);
        utente.setDdn(LocalDate.parse(data));

        ud.doSave(utente);
    }

    private UtenteBean login(String email, String password) {
        UtenteDao ud = new UtenteDao();
        UtenteBean utente = new UtenteBean();
        utente = ud.findAccount(email, password);
        return utente;
    }

    private void interireInListaPreferiti(int u, int c) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doSave(u,c);
    }

    private void rimuoviDaListaPreferiti(int c) {
        ListaPreferitiDao ld = new ListaPreferitiDao();
        ld.doDelateCorso(c);
    }

    private ArrayList<UtenteBean> visualizzaUtenti() throws SQLException {
        ArrayList<UtenteBean> utenti = new ArrayList<>();
        UtenteDao ud = new UtenteDao();
        utenti = ud.doRetriveAll();
        return utenti;
    }

    private void rendiAdmin(UtenteBean u) {
        UtenteDao ud = new UtenteDao();
        ud.doUpdateAdmin(u);
    }

}
