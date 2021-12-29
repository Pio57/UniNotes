package Controller;

import Model.Corso.CorsoBean;
import Model.Corso.CorsoDao;
import Model.Libretto.LibrettoBean;
import Model.Libretto.LibrettoDao;
import Model.MaterialeDidattico.MaterialeDidatticoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LibrettoServlet", value = "/Libretto/*")
public class LibrettoServlet extends HttpServlet {

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private ArrayList<LibrettoBean> visualizzaCorsi(){
        LibrettoDao ld = new LibrettoDao();
        return ld.dore;
    }

    private CorsoBean visualizzaCorso(int id){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveById(id);
    }

    private CorsoBean inserisciCorso(CorsoBean c){
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
    }*/

}