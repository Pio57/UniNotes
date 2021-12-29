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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private ArrayList<LibrettoBean> visualizzaLibretto(){
        LibrettoDao ld = new LibrettoDao();
        return ld.doRetriveAll();
    }

    private LibrettoBean visualizzaLibretto(int id){
        LibrettoDao lb = new LibrettoDao();
        return lb.doRetriveById(id);
    }

    private LibrettoBean inserisciLibretto(LibrettoBean l){
        LibrettoDao ld = new LibrettoDao();
        if(ld.doSave(l))
            return l;
        return null;
    }

    private LibrettoBean eliminaLibretto(LibrettoBean l){
        LibrettoDao ld = new LibrettoDao();
        if(ld.doDelate(l.getIdLibretto()))
            return l;
        return null;
    }

    private LibrettoBean modificaLibretto(LibrettoBean l){
       LibrettoDao ld = new LibrettoDao();
        if(ld.doUpdate(l))
            return l;
        return null;
    }



}