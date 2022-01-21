import Application.Utente.ServiceUtente.UtenteServiceImpl;
import Application.Utente.UtenteServlet;
import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UtenteServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private UtenteServlet us;



    @Before
    public void setUp(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        us = new UtenteServlet();
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
    }

    @Test
    public void homeTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        when(request.getPathInfo()).thenReturn("/home");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        us.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void homeTestUtenteNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        when(request.getPathInfo()).thenReturn("/home");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        us.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }



}
