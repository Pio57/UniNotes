package Servlet;

import Application.Corso.ServiceCorso.CorsoService;
import Application.Libretto.LibrettoServlet;
import Application.Libretto.ServiceLibretto.LibrettoService;
import Application.Libretto.ServiceLibretto.LibrettoServiceImpl;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoService;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoServiceImpl;
import Application.Utente.ServiceUtente.UtenteService;
import Application.Utente.ServiceUtente.UtenteServiceImpl;
import Storage.Libretto.LibrettoBean;
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
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LibrettoServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private MaterialeDidatticoService materialeDidatticoService;
    private LibrettoService librettoService;
    private CorsoService corsoService;
    private UtenteService utenteService;
    private LibrettoServlet ls;


    @Before
    public void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        ls = new LibrettoServlet();
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        materialeDidatticoService = new MaterialeDidatticoServiceImpl();
        utenteService = new UtenteServiceImpl();
        librettoService = new LibrettoServiceImpl();
    }

    @Test
    public void DoGetPathNull() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn(null);
        when(request.getSession()).thenReturn(session);

        try {
            ls.doGet(request, response);
        }catch (RuntimeException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }

    }

    @Test
    public void DoPostPathNull() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn(null);
        when(request.getSession()).thenReturn(session);

        try {
            ls.doPost(request, response);
        }catch (RuntimeException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }

    }


    @Test
    public void DoGetVisualizzaTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean("nome", "cognome","cf","email", LocalDate.of(2000,12,21), "prova",true);
        LibrettoBean l = new LibrettoBean(5, 30, 10);
        u.setLibretto(l);
        int id = u.getLibretto().getIdLibretto();

        when(request.getPathInfo()).thenReturn("/visualizzaLibretto");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        ls.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetVisualizzaUtenteNullTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);

        when(request.getPathInfo()).thenReturn("/visualizzaLibretto");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);

        ls.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DoPostVisualizzaNullTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/visualizzaLibretto");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        ls.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
}
