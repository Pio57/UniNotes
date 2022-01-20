import Application.Corso.ServiceCorso.CorsoServiceImpl;
import Application.ListaPreferiti.ServiceListaPreferiti.ListaPreferitiImpl;
import Application.ListaPreferiti.ServiceListaPreferiti.ListaPreferitiService;
import Storage.Corso.CorsoBean;
import Storage.Corso.CorsoDao;
import Storage.ListaPreferiti.ListaPreferitiBean;
import Storage.ListaPreferiti.ListaPreferitiDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListaPreferitiDaoTest {

    private ListaPreferitiDao listaPreferitiDao;
    private ListaPreferitiImpl listaPreferitiService;//valutare se serve anche nelle altre classi
/*
    @Before
    public void setUp(){
        listaPreferitiDao = new ListaPreferitiDao();
        listaPreferitiService = new ListaPreferitiImpl();
    }

    @Test
    public void doSaveTest(){
        ListaPreferitiBean l = new ListaPreferitiBean();
        assertEquals(true,listaPreferitiDao.doSave(22,14));//id da rivedere
    }
/*
    @Test
    public void doSaveTestRuntimeException(){
        CorsoBean c = new CorsoBean();
        try{
            corsoDao.doSave(c);
        }catch (RuntimeException e){
            Assert.assertEquals(" Column 'nome' cannot be null",e.getMessage().split(":")[1]);
        }

    }


    @Test
    public void doRetriveAllByIdUtenteTest(){
        int id=22;
        ListaPreferitiBean l = listaPreferitiDao.doRetriveAllByIdUtente(id);
        assertEquals(id, l.getIdUtente());
    }


    @Test
    public void doDelateCorsoTest(){
        CorsoBean c = new CorsoBean();
        c.setId(12);
        try{
            assertEquals(true,corsoDao.doUpdate(c));
        }catch (RuntimeException e){
            Assert.assertEquals(" Column 'nome' cannot be null",e.getMessage().split(":")[1]);
        }

    }

   */
}
