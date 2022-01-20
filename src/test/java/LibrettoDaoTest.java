import Application.Corso.ServiceCorso.CorsoServiceImpl;
import Application.Libretto.ServiceLibretto.LibrettoService;
import Application.Libretto.ServiceLibretto.LibrettoServiceImpl;
import Storage.Corso.CorsoBean;
import Storage.Corso.CorsoDao;
import Storage.Libretto.LibrettoBean;
import Storage.Libretto.LibrettoDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibrettoDaoTest {

    private LibrettoDao librettoDao;
    private LibrettoServiceImpl librettoService;

    @Before
    public void setUp(){
        librettoDao = new LibrettoDao();
        librettoService = new LibrettoServiceImpl();
    }

    @Test
    public void doSaveTest(){
        LibrettoBean l = new LibrettoBean();
        l.setMedia(0);
        l.setNunEsami(0);
        l.setCfuCrediti(0);
        assertEquals(true,librettoDao.doSave(l));
    }

    @Test
    public void doSaveTestRuntimeException(){//non funzione
        LibrettoBean l = new LibrettoBean();
        try{
            librettoDao.doSave(l);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(" Column 'numEsami' cannot be null",e.getMessage().split(":")[1]);
        }

    }



    @Test
    public void doRetriveByIdTest(){
        int id=1;
        LibrettoBean l = librettoDao.doRetriveById(id);
        assertEquals(id, l.getIdLibretto());
    }


    @Test
    public void doRetriveByIdUtenteTest(){
        int idUtente=4;
        int id = 1;
        LibrettoBean l = librettoDao.doRetriveByIdUtente(idUtente);
        assertEquals(id, l.getIdLibretto());
    }


/*
    @Test
    public void doRetriveAllTest(){
        ArrayList<LibrettoBean> list = librettoDao();
        int size = list.size();
        assertEquals(size, list.size());
    }
*/


    @Test
    public void doUpdateTest(){
        LibrettoBean l = new LibrettoBean();
        l.setIdLibretto(2);
        l.setMedia(1);
        l.setCfuCrediti(1);
        l.setNunEsami(1);
        assertEquals(true,librettoDao.doUpdate(l));
    }

    @Test
    public void doUpdateTestRuntimeException(){
        LibrettoBean l = new LibrettoBean();
        l.setIdLibretto(2);
        try{
            assertEquals(true,librettoDao.doUpdate(l));
        }catch (RuntimeException e){
            Assert.assertEquals(" Column 'numEsami' cannot be null",e.getMessage().split(":")[1]);
        }

    }


/*
    @Test
    public void doDelateTest(){

    }
*/

}
