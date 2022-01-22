import Application.Corso.ServiceCorso.CorsoServiceImpl;
import Application.ListaPreferiti.ServiceListaPreferiti.ListaPreferitiImpl;
import Application.ListaPreferiti.ServiceListaPreferiti.ListaPreferitiService;
import Storage.Corso.CorsoBean;
import Storage.Corso.CorsoDao;
import Storage.ListaPreferiti.ListaPreferitiBean;
import Storage.ListaPreferiti.ListaPreferitiDao;
import Storage.Utente.UtenteBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListaPreferitiDaoTest {

    private ListaPreferitiDao listaPreferitiDao;
    private ListaPreferitiImpl listaPreferitiService;

    @Before
    public void setUp(){
        listaPreferitiDao = new ListaPreferitiDao();
        listaPreferitiService = new ListaPreferitiImpl();
    }

    @Test
    public void doSaveTest(){

        assertEquals(true,listaPreferitiDao.doSave(4,2));
    }

    @Test
    public void doRetriveAllByIdUtenteTest(){
        int id=3;
        ListaPreferitiBean l = listaPreferitiDao.doRetriveAllByIdUtente(id);
        assertEquals(id, l.getIdUtente());
    }

    /*
    @Test
    public void doDelateCorsoTest(){

        ListaPreferitiBean l1 = listaPreferitiDao.doRetriveAllByIdUtente(3);
        listaPreferitiService.rimuoviDaListaPreferiti(3, 1);
        assertEquals(l1.getCorsi().size(),listaPreferitiDao.doRetriveAllByIdUtente(3).getCorsi().size()+1);


    }*/

}
