package Servlet;

import Application.Corso.ServiceCorso.CorsoService;
import Application.Corso.ServiceCorso.CorsoServiceImpl;
import Application.Libretto.ServiceLibretto.LibrettoService;
import Application.Libretto.ServiceLibretto.LibrettoServiceImpl;
import Application.MaterialeDidattico.MaterialeDidatticoServlet;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoServiceImpl;
import Application.Utente.ServiceUtente.UtenteService;
import Application.Utente.ServiceUtente.UtenteServiceImpl;
import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Collection;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MaterialeDidatticoServletTest {


    HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private MaterialeDidatticoServiceImpl materialeDidatticoService;
    private LibrettoService librettoService;
    private CorsoService corsoService;
    private UtenteService utenteService;
    private MaterialeDidatticoServlet ms;
    private UtenteDao ud;


    @Before
    public void setUp(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        ms = new MaterialeDidatticoServlet();
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        materialeDidatticoService = new MaterialeDidatticoServiceImpl();
        utenteService = new UtenteServiceImpl();
        corsoService = new CorsoServiceImpl();
        librettoService = new LibrettoServiceImpl();
        ud = Mockito.mock(UtenteDao.class);
    }

    @Test
    public void DoGetEliminaTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);

        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getParameter("id")).thenReturn("2");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        ms.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    //il controllo di elimina materiale ritorna false
    @Test
    public void DoGetEliminaTestEliminaMaterialeFalse() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);

        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getParameter("id")).thenReturn("100");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        ms.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }


    @Test
    public void DoGetEliminaTestUtenteNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);

        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        when(request.getParameter("id")).thenReturn("100");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        ms.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }



    //visualizza admin
    @Test
    public void DoGetVisualizzaTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        u.setTipo(true);

        when(request.getPathInfo()).thenReturn("/visualizza");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        ms.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGeVisualizzaTestUtenteNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);

        when(request.getPathInfo()).thenReturn("/visualizza");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        when(request.getParameter("id")).thenReturn("100");

        ms.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    //visualizza studente
    @Test
    public void DoGetVisualizzaTestUtenteIsNotTipo() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        u.setTipo(false);

        when(request.getPathInfo()).thenReturn("/visualizza");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getParameter("id")).thenReturn("100");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        ms.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    //visualizza tutti admin
    @Test
    public void DoGetVisualizzaTuttiTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        u.setTipo(true);

        when(request.getPathInfo()).thenReturn("/visualizzaTutti");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        ms.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    //visualizza tutti studente
    @Test
    public void DoGetVisualizzaTuttiTestUtenteIsNotTipo() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        u.setTipo(false);

        when(request.getPathInfo()).thenReturn("/visualizzaTutti");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        ms.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }



    @Test
    public void DoGeVisualizzaTuttiTestUtenteNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);

        when(request.getPathInfo()).thenReturn("/visualizzaTutti");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        when(request.getParameter("id")).thenReturn("100");

        ms.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }


    @Test
    public void DoPostInserisciMaterialeTestUtenteNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);

        when(request.getPathInfo()).thenReturn("/inserireMateriale");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);

        ms.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DoPostInserisciMaterialeTestIfNotMatches() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);

        when(request.getPathInfo()).thenReturn("/inserireMateriale");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        when(request.getParameter("Nome")).thenReturn("123");

        ms.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }


    @Test
    public void DoPostModificaMaterialeTestUtenteNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);

        when(request.getPathInfo()).thenReturn("/modificaMateriale");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("IdCorso")).thenReturn("4");
        when(session.getAttribute("utente")).thenReturn(null);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);


        ms.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }



}
