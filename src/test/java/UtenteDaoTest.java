import Application.Libretto.ServiceLibretto.LibrettoService;
import Application.Utente.ServiceUtente.UtenteServiceImpl;
import Storage.Libretto.LibrettoBean;
import Storage.Libretto.LibrettoDao;
import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;



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
        u.setIdUtente(12);//qui ci va l'id del nuovo elemento
        u.setNome("provaNome");
        u.setCognome("provaC");
        u.setCf("provacf");
        u.setEmail("provaEmail");
        u.setDdn(LocalDate.of(2016, 1, 1));
        u.setPss("prova123");
        u.setTipo(false);
        u.setLibretto(new LibrettoBean(2,new ArrayList<>()));
        assertEquals(true,utenteDAO.doUpdate(u));
    }

    @Test
    public void doUpdateAdminTest() throws SQLException {
        UtenteBean u = new UtenteBean();
        u.setIdUtente(12);
        u.setNome("provaNome");
        u.setCognome("provaC");
        u.setCf("provacf");
        u.setEmail("provaEmail");
        u.setDdn(LocalDate.of(2016, 1, 1));
        u.setPss("prova123");
        u.setTipo(false);
        u.setLibretto(new LibrettoBean(2,new ArrayList<>()));
        assertEquals(true,utenteDAO.doUpdateAdmin(u));
    }



    @Test
    public void findAccountTest(){
        UtenteBean u = utenteDAO.findAccount("provaEmail","prova123");
        assertEquals(12, u.getIdUtente());
    }
/*

    @Test
    public void doDeleteTest() throws SQLException {
        utenteDAO.doDelate(11);
        assertEquals(11,utenteDAO.doRetriveById(11));
    }

*/


}
