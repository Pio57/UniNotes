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
                CorsoBean c = visualizzaCorso(2);
                request.setAttribute("Corso",c);//togliere l'id statico --> mettendone uno dinamico
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizza.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTutti":{
                ArrayList<CorsoBean> c = visualizzaCorsi();
                System.out.println(c.get(0).getNome());
                request.setAttribute("corsi",visualizzaCorsi());
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
                response.sendRedirect("/UniNotes_war_exploded/");
                break;
            }
            case "/elimina":{
                String id = request.getParameter("id");
                eliminaCorso(Integer.parseInt(id));
                request.getRequestDispatcher("/UniNotes_war_exploded/").forward(request,response);
                break;
            }
            case "/modifica":{
                String id = request.getParameter("idCorso");
                String nome = request.getParameter("Nome");
                String descrizione = request.getParameter("Descrizione");
                String nomeProfessore = request.getParameter("NomeProfessore");
                modificaCorso(Integer.parseInt(id),nome,descrizione,nomeProfessore);
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

    private ArrayList<CorsoBean> visualizzaCorsi(){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveAll();
    }

    private CorsoBean visualizzaCorso(int id){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveById(id);
    }

    private CorsoBean inserisciCorso( String nome, String descrizione,String nomeProfessore){ //ho modificato i parametri da passare --> modifira nell' odd
        CorsoBean c = new CorsoBean(nome,descrizione,nomeProfessore);
        CorsoDao cd = new CorsoDao();
        if(cd.doSave(c))
            return c;
        return null;
    }

    private boolean eliminaCorso(int idCorso){//qui ho aggiunto l'id per individuare il corso --> modificare nell'odd
        CorsoDao cd = new CorsoDao();
        if(cd.doDelate(idCorso))
            return true;
        return false;
    }

    private CorsoBean modificaCorso(int id,String nome, String descrizione,String nomeProfessore){
        CorsoDao cd = new CorsoDao();
        CorsoBean c = new CorsoBean(id,nome,descrizione,nomeProfessore);
        if(cd.doUpdate(c))
            return c;
        return null;
    }

    private ArrayList<MaterialeDidatticoBean> visualizzaTuttoIlMateriale(int id){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveById(id).getListaMateriale();
    }

}
