package Controller;

import Model.Corso.CorsoBean;
import Model.MaterialeDidattico.MaterialeDidatticoBean;
import Model.MaterialeDidattico.MaterialeDidatticoDao;
import Model.Utente.UtenteBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@WebServlet(name = "MaterialeDidatticoServlet", value = "/Materiale/*")
@MultipartConfig
public class MaterialeDidatticoServlet extends HttpServlet {

    UtenteBean u;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/inserireMateriale":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/crea.jsp").forward(request,response);
                break;
            }
            case "/eliminaMateriale":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/elimina.jsp").forward(request,response);
                break;
            }
            case "/modificaMateriale":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/modifica.jsp").forward(request,response);
                break;
            }
            case "/visualizza":{
                request.setAttribute("materiale",visualizza(5));//togliere l'id statico --> mettendone uno dinamico
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/visualizza.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTutti":{
                ArrayList<MaterialeDidatticoBean> c = visualizzaTutti();
                request.setAttribute("materiali",c);//ho cambiato la path per farlo andare nella dashboard --> bisogna rivederla
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaUtente/dashboard/materiale.jsp").forward(request,response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = (request.getPathInfo() != null) ? request.getPathInfo() : "/";
        switch (path){
            case "/inserireMateriale":{
                String idCorso = request.getParameter("idCorso");
                String idUtente = request.getParameter("idUtente");
                String nome = request.getParameter("Nome");
                Part filePart = request.getPart("File");
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                if(inserireMateriale(nome,fileName,Integer.parseInt(idCorso),Integer.parseInt(idUtente))){
                    String uploadRoot = "/Users/piosantosuosso/Desktop/apache-tomcat-9.0.43/uploads/";

                    try (InputStream fileStream = filePart.getInputStream()) {
                        File file = new File(uploadRoot + fileName);
                        Files.copy(fileStream, file.toPath());
                        response.sendRedirect("/UniNotes_war_exploded/");
                        break;
                    }
               }

                response.sendRedirect("/UniNotes_war_exploded/");
                break;



            }
            case "/eliminaMateriale":{
                String id = request.getParameter("id");
                eliminaMateriale(Integer.parseInt(id));
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/elimina.jsp").forward(request,response);
                break;
            }
            case "/modificaMateriale":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/modifica.jsp").forward(request,response);
                break;
            }
            case "/visualizza":{
                request.setAttribute("materiale",visualizza(2));//togliere l'id statico --> mettendone uno dinamico
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/visualizza.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTutti":{
                ArrayList<MaterialeDidatticoBean> c = visualizzaTutti();
                request.setAttribute("materiali",c);
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/visualizzaTutti.jsp").forward(request,response);
                break;
            }
        }


    }

    private boolean inserireMateriale(String nome,String pathFile , int idCorso,int idUtente){//qui ho aggiunto un parametro in più , e ho campbiato il valore di ritorno in un booleano
       MaterialeDidatticoBean m = new MaterialeDidatticoBean(nome,pathFile);
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        if( md.doSave(m,idCorso,idUtente))
            return true;
        return false;
    }

    private boolean eliminaMateriale(int id){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doDelate(id);

    }
/*
    private ArrayList<MaterialeDidatticoBean> eliminaMateriale(MaterialeDidatticoBean m, CorsoBean c){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        md.doDelate(m.getId());
        return md.doRetriveAllByIdUtente(u.getIdUtente());
    }
*/
    private MaterialeDidatticoBean modificaMateriale(MaterialeDidatticoBean m){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
         if(md.doUpdate(m))
             return m;
         return null;
    }

    private MaterialeDidatticoBean visualizza(int id){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doRetriveById(id);
    }

    private ArrayList<MaterialeDidatticoBean> visualizzaTutti(){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doRetriveAll();
    }





}
