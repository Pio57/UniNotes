package Controller;

import Model.Esame.EsameBean;
import Model.Esame.EsameDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;


@WebServlet(name = "EsameServlet", value = "/Esame/*")
public class EsameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/crea":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaEsame/crea.jsp").forward(request,response);
                break;
            }
            case "/elimina":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaEsame/elimina.jsp").forward(request,response);
                break;
            }
            case "/modifica":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaEsame/modifica.jsp").forward(request,response);
                break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/crea":{
                String nome = request.getParameter("nome");
                String nomeProfessore = request.getParameter("nomeProfessore");
                int cfu=Integer.parseInt(request.getParameter("cfu"));
                float voto= Float.parseFloat(request.getParameter("voto"));
                //Date data = LocalDate.parse(request.getParameter("dataEsame"));
                Date data=new Date();
                inserisciEsame(nome,nomeProfessore,voto,cfu,data);
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
            default:
                throw new IllegalStateException("Unexpected value: " + path);
        }
    }

    private EsameBean inserisciEsame(String nome,String nomeProfessore,float voto,int cfu, Date data){
        EsameDao ed = new EsameDao();
        EsameBean e=new EsameBean();
        e.setCfu(cfu);
        e.setData(data);
        e.setNome(nome);
        e.setNomeProfessore(nomeProfessore);
        e.setVoto(voto);

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