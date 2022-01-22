package Dao;

import Application.Corso.ServiceCorso.CorsoServiceImpl;
import Storage.Corso.CorsoBean;
import Storage.Corso.CorsoDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CorsoDaoTest {
    private CorsoDao corsoDao;
    private CorsoServiceImpl corsoService;

    @Before
    public void setUp(){
        corsoDao = new CorsoDao();
        corsoService = new CorsoServiceImpl();
    }

    @Test
    public void doSaveTest(){
        CorsoBean c = new CorsoBean();
        c.setNome("CorsoNome");
        c.setDescrizione("DescrizioneCorso");
        c.setNomeProfessore("NomeProfessore");
        assertEquals(true,corsoDao.doSave(c));
    }

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
    public void doRetriveByIdTest(){
        int id=2;
        CorsoBean c = corsoDao.doRetriveById(id);
        assertEquals(id, c.getId());
    }
/*
    @Test
    public void doUpdateTestRuntimeException(){
        CorsoBean c = new CorsoBean();
        c.setId(9);
        try{
            assertEquals(true,corsoDao.doUpdate(c));
        }catch (RuntimeException e){
            Assert.assertEquals(" Column 'nome' cannot be null",e.getMessage().split(":")[1]);
        }

    }
*/
    @Test
    public void doRetriveAllTest(){
        ArrayList<CorsoBean> list = corsoDao.doRetriveAll();
        int size = list.size();
        assertEquals(size, list.size());
    }



    @Test
    public void doUpdateTest(){
        CorsoBean c = new CorsoBean();
        c.setId(8);
        c.setNome("CorsoNomeProva");
        c.setDescrizione("DescrizioneCorso");
        c.setNomeProfessore("NomeProfessore");
        assertEquals(true,corsoDao.doUpdate(c));
    }


/*
    @Test
    public void doDelateTest(){

    }
*/
}
