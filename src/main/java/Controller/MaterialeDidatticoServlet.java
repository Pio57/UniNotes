package Controller;

import Model.Corso.CorsoBean;
import Model.MaterialeDidattico.MaterialeDidatticoBean;
import Model.MaterialeDidattico.MaterialeDidatticoDao;
import Model.Utente.UtenteBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MaterialeDidatticoServlet", value = "/Materiale/*")
public class MaterialeDidatticoServlet extends HttpServlet {

    UtenteBean u;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private MaterialeDidatticoBean inserireMateriale(MaterialeDidatticoBean m, int idCorso,int idUtente){//qui ho aggiunto un parametro in più
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        if( md.doSave(m,idCorso,idUtente))
            return m;
        return null;
    }

    private ArrayList<MaterialeDidatticoBean> eliminaMateriale(MaterialeDidatticoBean m, CorsoBean c){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        md.doDelate(m.getId());
        return md.doRetriveAllByIdUtente(u.getIdUtente());
    }

    private MaterialeDidatticoBean modificaMateriale(MaterialeDidatticoBean m){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
         if(md.doUpdate(m))
             return m;
         return null;
    }



}
