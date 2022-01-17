package Application.MaterialeDidattico;

import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoService;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoServiceImpl;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;
import Storage.Utente.UtenteBean;

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

    private final MaterialeDidatticoService materialeDidattico = new MaterialeDidatticoServiceImpl();


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

                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }
                if(u.isTipo()){
                   request.setAttribute("materiale",materialeDidattico.visualizzaTutti());
                }else{
                    request.setAttribute("materiale",materialeDidattico.visualizzaMaterialeDiUnUtente(u.getIdUtente()));
                }
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/visualizza.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTutti":{
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }
                if(u.isTipo()){
                    request.setAttribute("materiale",materialeDidattico.visualizzaTutti());
                }else{
                    request.setAttribute("materiale",materialeDidattico.visualizzaMaterialeDiUnUtente(u.getIdUtente()));
                }
                //ho cambiato la path per farlo andare nella dashboard --> bisogna rivederla
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
                HttpSession ssn = request.getSession();
                UtenteBean u = (UtenteBean) ssn.getAttribute("utente");
                if(u == null){
                    response.sendRedirect("/UniNotes_war_exploded/");
                    break;
                }
                String idCorso = request.getParameter("idCorso");
                int idUtente = u.getIdUtente();
                String nome = request.getParameter("Nome");
                Part filePart = request.getPart("File");
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                if(materialeDidattico.inserireMateriale(nome,fileName,Integer.parseInt(idCorso),idUtente)){
                    String uploadRoot = "/Users/piosantosuosso/Desktop/apache-tomcat-9.0.43/uploads/";

                    try (InputStream fileStream = filePart.getInputStream()) {
                        File file = new File(uploadRoot + fileName);
                        Files.copy(fileStream, file.toPath());
                        response.sendRedirect("/UniNotes_war_exploded/Corso/visualizzaTutti");
                        break;
                    }
               }

                response.sendRedirect("/UniNotes_war_exploded/");
                break;



            }
            case "/eliminaMateriale":{
                String id = request.getParameter("id");
                materialeDidattico.eliminaMateriale(Integer.parseInt(id));
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/elimina.jsp").forward(request,response);
                break;
            }
            case "/modificaMateriale":{
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/modifica.jsp").forward(request,response);
                break;
            }
            case "/visualizza":{
                request.setAttribute("materiale",materialeDidattico.visualizza(2));//togliere l'id statico --> mettendone uno dinamico
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/visualizza.jsp").forward(request,response);
                break;
            }
            case "/visualizzaTutti":{
                ArrayList<MaterialeDidatticoBean> c = materialeDidattico.visualizzaTutti();
                request.setAttribute("materiali",c);
                request.getRequestDispatcher("/WEB-INF/interface/interfacciaMateriale/visualizzaTutti.jsp").forward(request,response);
                break;
            }
        }


    }
}
