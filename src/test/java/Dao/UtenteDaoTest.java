package Dao;

import Application.Utente.ServiceUtente.UtenteServiceImpl;
import Storage.Libretto.LibrettoBean;
import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteDao;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class UtenteDaoTest {
    private UtenteDao utenteDAO;
    private UtenteServiceImpl utenteService;

    @Before
    public void setUp(){
        utenteDAO = new UtenteDao();
        utenteService = new UtenteServiceImpl();
    }



    @Test
    public void doSaveTest() throws SQLException, NoSuchAlgorithmException {
        UtenteBean u = new UtenteBean();
        u.setNome("provaN");
        u.setCognome("provaC");
        u.setCf("provacf");
        u.setEmail("provaEmail");
        u.setDdn(LocalDate.of(2016, 1, 1));
        u.setPss("prova123");
        u.setTipo(false);
        u.setLibretto(new LibrettoBean(2,new ArrayList<>()));
        assertEquals("provaN",utenteDAO.doSave(u).getNome());
    }

    @Test
    public void doRetrieveByIdTest(){
        int id=1;
        UtenteBean u = utenteDAO.doRetriveById(id);
        assertEquals(id, u.getIdUtente());
    }

    @Test
    public void doRetriveAllTest(){
        ArrayList<UtenteBean> list = utenteDAO.doRetriveAll();
        int size = list.size();
        assertEquals(size, list.size());
    }



    @Test
    public void doUpdateTest() throws SQLException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(1);//qui ci va l'id del nuovo elemento
        u.setNome("provaNome");
        u.setCognome("provaC");
        u.setCf("provacf");
        u.setEmail("provaEmail");
        u.setDdn(LocalDate.of(2016, 1, 1));
        u.setPss("prova123");
        u.setTipo(false);
        u.setLibretto(new LibrettoBean(1,new ArrayList<>()));
        assertEquals(true,utenteDAO.doUpdate(u));
    }

    @Test
    public void doUpdateAdminTest() throws SQLException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(1);
        u.setNome("provaNome");
        u.setCognome("provaC");
        u.setCf("provacf");
        u.setEmail("provaEmail");
        u.setDdn(LocalDate.of(2016, 1, 1));
        u.setPss("prova123");
        u.setTipo(false);
        u.setLibretto(new LibrettoBean(1,new ArrayList<>()));
        assertEquals(true,utenteDAO.doUpdateAdmin(u));
    }



    @Test
    public void findAccountTest(){
        UtenteBean u = utenteDAO.findAccount("damianabuono2000@gmail.com","9b6d200bae47bd1d15563309d085f4e839f97c192684af7049368dfd6c2123e68e4205e1c4e3859ca90e8c8859a9095bda0100d3d2695ea031760a86878c89f7");
        assertEquals(6, u.getIdUtente());
    }

    @Test
    public void doDeleteTest() throws SQLException {
        ArrayList<UtenteBean> list1 = utenteDAO.doRetriveAll();
        utenteDAO.doDelate(3);
        ArrayList<UtenteBean> list2 = utenteDAO.doRetriveAll();
        assertEquals(list2.size(),list1.size()-1);
    }



}
