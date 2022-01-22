import Application.Corso.ServiceCorso.CorsoService;
import Application.ListaPreferiti.ListaPreferitiServlet;
import Application.ListaPreferiti.ServiceListaPreferiti.ListaPreferitiService;
import Application.Utente.ServiceUtente.UtenteService;
import Storage.Corso.CorsoBean;
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

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ListaPreferitiServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private CorsoService corsoService;
    private UtenteService utenteService;
    private UtenteDao ud;
    private ListaPreferitiService listaPreferitiService;
    private ListaPreferitiServlet lp;

    @Before
    public void setUp(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        lp = new ListaPreferitiServlet();
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        utenteService = Mockito.mock(UtenteService.class);
        corsoService = Mockito.mock(CorsoService.class);
        ud = Mockito.mock(UtenteDao.class);
        listaPreferitiService= Mockito.mock(ListaPreferitiService.class);
    }

    @Test
   public void DogetToggle() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(3);
        when(request.getPathInfo()).thenReturn("/toggle");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getParameter("idCorso")).thenReturn("6");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        lp.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }


    @Test
    public void DogetToggleNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        when(request.getPathInfo()).thenReturn("/toggle");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        when(request.getParameter("idCorso")).thenReturn("3");
        lp.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DogetToggleConAppartienefalso() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        when(request.getPathInfo()).thenReturn("/toggle");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getParameter("idCorso")).thenReturn("2");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        lp.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DogetVisualizza() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(1);
        when(request.getPathInfo()).thenReturn("/visualizza");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        lp.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DogetVisualizzaNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        when(request.getPathInfo()).thenReturn("/visualizza");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        lp.doGet(request, response);
        verify(response, atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DogetRemove() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(3);
        when(request.getPathInfo()).thenReturn("/rimuoviDallaFavoriteList");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getParameter("idCorso")).thenReturn("2");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        lp.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DogetRemoveNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(3);
        when(request.getPathInfo()).thenReturn("/rimuoviDallaFavoriteList");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        lp.doGet(request, response);
        verify(response, atLeastOnce()).sendRedirect(anyString());
    }

}
