package Integration;

import Application.Corso.CorsoServlet;
import Application.Corso.ServiceCorso.CorsoService;
import Application.Corso.ServiceCorso.CorsoServiceImpl;
import Application.Libretto.ServiceLibretto.LibrettoService;
import Application.Libretto.ServiceLibretto.LibrettoServiceImpl;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoService;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoServiceImpl;
import Application.Utente.ServiceUtente.UtenteService;
import Application.Utente.ServiceUtente.UtenteServiceImpl;
import Storage.Corso.CorsoBean;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;
import Storage.Utente.UtenteBean;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CorsoServletIntegrationTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private MaterialeDidatticoService materialeDidatticoService;
    private LibrettoService librettoService;
    private CorsoService corsoService;
    private UtenteService utenteService;
    private CorsoServlet cs;


    @Before
    public void setUp(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        cs = new CorsoServlet();
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        materialeDidatticoService = new MaterialeDidatticoServiceImpl();
        utenteService =new UtenteServiceImpl();
        corsoService = new CorsoServiceImpl();
        librettoService = new LibrettoServiceImpl();
    }

    @Test
    public void DoGetCreaTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/crea");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        cs.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetEliminaTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        CorsoBean c = new CorsoBean();

        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getParameter("id")).thenReturn("1");

        cs.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }


    @Test
    public void DoGetEliminaUtenteNullTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        cs.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }



    @Test
    public void DoGetModificaTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/modifica");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        cs.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetVisualizzaTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        CorsoBean c = new CorsoBean();
        ArrayList<MaterialeDidatticoBean> l = new ArrayList<>();

        when(request.getPathInfo()).thenReturn("/visualizza");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);

        when(request.getParameter("idCorso")).thenReturn("2");


        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cs.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetVisualizzaUtenteNullTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/visualizza");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        cs.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }


    @Test
    public void DoGetVisualizzaTuttiTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        CorsoBean c = new CorsoBean();
        ArrayList<CorsoBean> corsi = new ArrayList<>();

        when(request.getPathInfo()).thenReturn("/visualizzaTutti");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);

        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cs.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetVisualizzaTuttiUtenteNUllTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/visualizzaTutti");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        cs.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DoGetVisualizzaTuttiUtenteTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        CorsoBean c = new CorsoBean();
        ArrayList<CorsoBean> corsi = new ArrayList<>();

        when(request.getPathInfo()).thenReturn("/visualizzaTuttiUtente");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);

        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cs.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetVisualizzaTuttiUtenteUtenteNullTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/visualizzaTuttiUtente");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        cs.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }
/*
    @Test
    public void DoGetAggiungiAPreferitiTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        CorsoBean c = new CorsoBean();

        ArrayList<MaterialeDidatticoBean> l = new ArrayList<>();

        when(request.getPathInfo()).thenReturn("/aggiungiAPreferiti");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);

        when(request.getParameter("idCorso")).thenReturn("2");
        utenteService.interireInListaPreferiti(2,2);

        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cs.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
*/
    @Test
    public void DoGetAggiungiAPreferitiUtenteNUllTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/aggiungiAPreferiti");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        cs.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DoPostCreaTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        when(request.getPathInfo()).thenReturn("/crea");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);

        when(request.getParameter("Nome")).thenReturn("String");
        when(request.getParameter("Descrizione")).thenReturn("String");
        when(request.getParameter("NomeProfessore")).thenReturn("String");



        cs.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DoPostCreaUtenteNUllTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/crea");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        cs.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DoPostCreaifMatchesTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        CorsoBean c = new CorsoBean();
        when(request.getPathInfo()).thenReturn("/crea");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);

        when(request.getParameter("Nome")).thenReturn("Nome Corso");
        when(request.getParameter("Descrizione")).thenReturn("Descrizione corso");
        when(request.getParameter("NomeProfessore")).thenReturn("Nome Prof");

        cs.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    //test degli if che non matchano
    @Test
    public void DoPostCreaNOifMatchesTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        CorsoBean c = new CorsoBean();
        when(request.getPathInfo()).thenReturn("/crea");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);

        when(request.getParameter("Nome")).thenReturn("1223");
        when(request.getParameter("Descrizione")).thenReturn("D12345");
        when(request.getParameter("NomeProfessore")).thenReturn("23456");

        cs.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    /*
    @Test
    public void DoPostEliminaTest() throws ServletException, IOException {

        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getSession()).thenReturn(session);

        when(request.getParameter("id")).thenReturn("4");


        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cs.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
*/

    @Test
    public void DoPostModificaUtenteNUllTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/modifica");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        cs.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }


    @Test
    public void DoPostMOdificaifMatchesTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        CorsoBean c = new CorsoBean();
        when(request.getPathInfo()).thenReturn("/modifica");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);

        when(request.getParameter("id")).thenReturn("7");
        when(request.getParameter("Nome")).thenReturn("NomeCorso");
        when(request.getParameter("Descrizione")).thenReturn("escrizione corso");
        when(request.getParameter("NomeProfessore")).thenReturn("Nome Prof");

        cs.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    //test degli if che non matchano
    @Test
    public void DoPostMOdificaNOifMatchesTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        CorsoBean c = new CorsoBean();
        when(request.getPathInfo()).thenReturn("/crea");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);

        when(request.getParameter("id")).thenReturn("20");
        when(request.getParameter("Nome")).thenReturn("1223");
        when(request.getParameter("Descrizione")).thenReturn("D12345");
        when(request.getParameter("NomeProfessore")).thenReturn("23456");

        cs.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

}
