import Application.Corso.ServiceCorso.CorsoService;
import Application.Esame.EsameServlet;
import Application.Esame.ServiceEsame.EsameService;
import Application.Libretto.ServiceLibretto.LibrettoService;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoService;
import Application.Utente.ServiceUtente.UtenteService;
import Application.Utente.UtenteServlet;
import Storage.Esame.EsameBean;
import Storage.Libretto.LibrettoBean;
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
import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class EsameServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private MaterialeDidatticoService materialeDidatticoService;
    private LibrettoService librettoService;
    private EsameService esameService;
    private CorsoService corsoService;
    private UtenteService utenteService;
    private EsameServlet es;
    private UtenteDao ud;
    private Object IllegalArgumentException;


    @Before
    public void setUp(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        es = new EsameServlet();
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        materialeDidatticoService = Mockito.mock(MaterialeDidatticoService.class);
        utenteService = Mockito.mock(UtenteService.class);
        corsoService = Mockito.mock(CorsoService.class);
        librettoService = Mockito.mock(LibrettoService.class);
        esameService = Mockito.mock(EsameService.class);
        ud = Mockito.mock(UtenteDao.class);
    }



    @Test
    public void DoGetEliminaTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        LibrettoBean l = new LibrettoBean(0,0,0);
        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(session.getAttribute("libretto")).thenReturn(l);
        when(request.getParameter("id")).thenReturn("2");
        when(esameService.eliminaEsame(2)).thenReturn(true);


        es.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DoGetEliminaTestUtenteNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        LibrettoBean l = new LibrettoBean(0,0,0);
        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);
        when(session.getAttribute("libretto")).thenReturn(l);
        when(esameService.eliminaEsame(anyInt())).thenReturn(true);


        es.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    //Elimina esame ritorna false
    @Test
    public void DoGetEliminaTestEliminaEsameFalse() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        LibrettoBean l = new LibrettoBean(0,0,0);
        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(session.getAttribute("libretto")).thenReturn(l);
        when(request.getParameter("id")).thenReturn("10");
        when(esameService.eliminaEsame(anyInt())).thenReturn(false);


        es.doGet(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }


    @Test
    public void DoPostCreaTestUtenteNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        LibrettoBean l = new LibrettoBean(0,0,0);
        when(request.getPathInfo()).thenReturn("/crea");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);


        es.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DoPostCreaTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        LibrettoBean l = new LibrettoBean(0,0,0);
        l.setIdLibretto(2);
        EsameBean e = new EsameBean();
        when(request.getPathInfo()).thenReturn("/crea");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(session.getAttribute("libretto")).thenReturn(l);
        when(request.getPathInfo()).thenReturn("/crea");
        when(request.getParameter("Nome")).thenReturn("Materia");
        when(request.getParameter("NomeProfessore")).thenReturn("Mario Rossi");
        when(request.getParameter("Cfu")).thenReturn("9");
        when(request.getParameter("Voto")).thenReturn("25");
        when(request.getParameter("Data")).thenReturn("2020-12-12");
        when(esameService.inserisciEsame("Materia","Mario Rossi",25,9, LocalDate.of(2020,12,12),2)).thenReturn(e);
        when(librettoService.modificaLibretto(l)).thenReturn(l);


        es.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }


    @Test
    public void DoPostCreaTestIfNotMatches() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        LibrettoBean l = new LibrettoBean(0,0,0);
        when(request.getPathInfo()).thenReturn("/crea");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(session.getAttribute("libretto")).thenReturn(l);
        when(request.getParameter("Nome")).thenReturn("123");
        when(request.getParameter("NomeProfessore")).thenReturn("123");
        when(request.getParameter("Cfu")).thenReturn("0");
        when(request.getParameter("Voto")).thenReturn("15");
        when(request.getParameter("Data")).thenReturn("2020-12-12");


        es.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }


    @Test
    public void DoPostModificaTest() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        LibrettoBean l = new LibrettoBean(0,0,0);
        l.setIdLibretto(2);
        EsameBean e = new EsameBean();
        when(request.getParameter("id")).thenReturn("4");
        when(request.getPathInfo()).thenReturn("/modifica");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(u);
        when(session.getAttribute("libretto")).thenReturn(l);
        when(request.getParameter("Nome")).thenReturn("Materia");
        when(request.getParameter("NomeProfessore")).thenReturn("Mario Rossi");
        when(request.getParameter("Cfu")).thenReturn("9");
        when(request.getParameter("Voto")).thenReturn("25");
        when(request.getParameter("Data")).thenReturn("2020-12-12");
        when(esameService.modificaEsame(4,"Materia","Mario Rossi",25,9, LocalDate.of(2020,12,12))).thenReturn(e);
        //when(librettoService.modificaLibretto(l)).thenReturn(l);


        es.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    //se non metchano le variabili
    @Test
    public void DoPostModificaTestIfNotMatches() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        LibrettoBean l = new LibrettoBean(0,0,0);
        l.setIdLibretto(2);
        EsameBean e = new EsameBean();
        when(request.getPathInfo()).thenReturn("/modifica");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("id")).thenReturn("3");
        when(session.getAttribute("utente")).thenReturn(u);
        when(session.getAttribute("libretto")).thenReturn(l);
        when(request.getParameter("Nome")).thenReturn("123");
        when(request.getParameter("NomeProfessore")).thenReturn("123");
        when(request.getParameter("Cfu")).thenReturn("0");
        when(request.getParameter("Voto")).thenReturn("15");
        when(request.getParameter("Data")).thenReturn("2020-12-12");


        es.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    @Test
    public void DoPostModificaTestUtenteNull() throws ServletException, IOException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(2);
        LibrettoBean l = new LibrettoBean(0,0,0);
        when(request.getParameter("id")).thenReturn("2");
        when(request.getPathInfo()).thenReturn("/modifica");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn(null);


        es.doPost(request,response);
        verify(response,atLeastOnce()).sendRedirect(anyString());
    }

    //path null
    @Test
    public void DoPostPathNull() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn(null);
        when(request.getSession()).thenReturn(session);

        try {
            es.doPost(request, response);
        }catch (RuntimeException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }

    }

}
