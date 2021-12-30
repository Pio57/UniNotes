package Controller;

import Model.Corso.CorsoBean;
import Model.Corso.CorsoDao;
import Model.MaterialeDidattico.MaterialeDidatticoBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CorsoServlet", value = "/Corso/*")
public class CorsoServlet extends HttpServlet {

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
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizza.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTutti":{
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
                inserisciCorso(nome,descrizione,nomeProfessore);
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
        }
    }

    private ArrayList<CorsoBean> visualizzaCorsi(){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveAll();
    }

    private CorsoBean visualizzaCorso(int id){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveById(id);
    }

    private CorsoBean inserisciCorso( String nome, String descrizione,String nomeProfessore){
        CorsoBean c = new CorsoBean(nome,descrizione,nomeProfessore);
        CorsoDao cd = new CorsoDao();
        if(cd.doSave(c))
            return c;
        return null;
    }

    private CorsoBean eliminaCorso(CorsoBean c){
        CorsoDao cd = new CorsoDao();
        if(cd.doDelate(c.getId()))
            return c;
        return null;
    }

    private CorsoBean modificaCorso(CorsoBean c){
        CorsoDao cd = new CorsoDao();
        if(cd.doUpdate(c))
            return c;
        return null;
    }

    private ArrayList<MaterialeDidatticoBean> visualizzaTuttoIlMateriale(int id){//qui ho aggiunto l'id per individuare il corso
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveById(id).getListaMateriale();
    }

}
