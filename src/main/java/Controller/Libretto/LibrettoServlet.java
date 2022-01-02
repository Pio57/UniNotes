package Controller.Libretto;

import Controller.Esame.ServiceEsame.EsameService;
import Controller.Esame.ServiceEsame.EsameServiceImpl;
import Controller.Libretto.ServiceLibretto.LibrettoService;
import Controller.Libretto.ServiceLibretto.LibrettoServiceImpl;
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

    private final LibrettoService librettoService= new LibrettoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/visualizzaLibretto":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaLibretto/visualizzaLibretto").forward(request,response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){

            case "/visualizzaLibretto":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaCorso/visualizza.jsp").forward(request,response);
                break;
            }
        }
    }



}