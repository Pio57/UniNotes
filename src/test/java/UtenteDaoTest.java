import Application.Utente.ServiceUtente.UtenteServiceImpl;
import Storage.Utente.UtenteBean;
import Storage.Utente.UtenteDao;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtenteDaoTest {
    private UtenteDao utenteDAO;
    private UtenteServiceImpl utenteService;
    @Before
    public void setUp(){
        utenteDAO=new UtenteDao();
        utenteService = new UtenteServiceImpl();
    }

    @Test
    public void doRetrieveByIdTest(){
        int id=1;
        UtenteBean u=utenteDAO.doRetriveById(id);
        assertEquals(id, u.getIdUtente());
    }
}
