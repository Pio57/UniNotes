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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UtenteServlet", value = "/Utente/*")
public class UtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/registrazione":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/registrazione.jsp").forward(request,response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/registrazione":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/registrazione.jsp").forward(request,response);
                break;
            }
        }
    }

    private void registrazione(UtenteBean u) throws SQLException {
        UtenteDao ud = new UtenteDao();
        ud.doSave(u);
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

    private void visualizzaUtenti() throws SQLException {
        ArrayList<UtenteBean> utenti = new ArrayList<>();
        UtenteDao ud = new UtenteDao();
        utenti = ud.doRetriveAll();
    }

    private void rendiAdmin(UtenteBean u) {
        UtenteDao ud = new UtenteDao();
        ud.doUpdateAdmin(u);
    }

}
