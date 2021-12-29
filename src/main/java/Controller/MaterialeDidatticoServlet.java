package Controller;

import Model.Corso.CorsoBean;
import Model.MaterialeDidattico.MaterialeDidatticoBean;
import Model.MaterialeDidattico.MaterialeDidatticoDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MaterialeDidatticoServlet", value = "/Materiale/*")
public class MaterialeDidatticoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private MaterialeDidatticoBean inserireMateriale(MaterialeDidatticoBean m, CorsoBean c,int idUtente){//qui ho aggiunto un parametro in più
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        if( md.doSave(m,c.getId(),idUtente))
            return m;
        return null;
    }


}
