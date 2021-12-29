package Controller;

import Model.Corso.CorsoBean;
import Model.Esame.EsameBean;
import Model.Esame.EsameDao;
import Model.Libretto.LibrettoBean;
import Model.MaterialeDidattico.MaterialeDidatticoBean;
import Model.MaterialeDidattico.MaterialeDidatticoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "EsameServlet", value = "/Esame/*")
public class EsameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private EsameBean inserireEsame(EsameBean e){
        EsameDao ed = new EsameDao();
        if( ed.doSave(e))
            return e;
        return null;
    }

    private EsameBean eliminaEsame(EsameBean e){
        EsameDao ed = new EsameDao();
       ed.doDelate(e.getId());
            return e;
    }

    private EsameBean modificaEsame(EsameBean e){ /// da rivedere
        EsameDao ed = new EsameDao();
        if( ed.doUpdate(e))
            return e;
        return null;
    }

}