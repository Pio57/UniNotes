package Dao;

import Application.Esame.ServiceEsame.EsameServiceImpl;
import Storage.Esame.EsameBean;
import Storage.Esame.EsameDao;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class EsameDaoTest {
    private EsameDao esameDAO;
    private EsameServiceImpl esameService;

    @Before
    public void setUp(){
        esameDAO = new EsameDao();
        esameService = new EsameServiceImpl();
    }

    @Test
    public void doRetrieveByIdTest(){
        int id=3;
        EsameBean e = esameDAO.doRetriveById(id);
        assertEquals(id, e.getId());
    }
/*
    @Test
    public void doRetriveAllTest(){
        ArrayList<EsameBean> list = esameDAO.doRetriveAll();
        int size = list.size();
        assertEquals(size, list.size());
    }

 */

    @Test
    public void doSaveTest(){
        EsameBean e = new EsameBean();
        e.setNome("provaN");
        e.setVoto(18);
        e.setCfu(12);
        e.setData(LocalDate.of(2016, 1, 1));
        e.setNomeProfessore("provaNomeProf");
        assertEquals(true,esameDAO.doSave(e, 1));
    }

    @Test
    public void doUpdateTest(){
        EsameBean e = new EsameBean();
        e.setId(4);
        e.setNome("provaNome");
        e.setVoto(29);
        e.setCfu(12);
        e.setData(LocalDate.of(2016, 1, 1));
        e.setNomeProfessore("provaNomeProfessore");
        assertEquals(true,esameDAO.doUpdate(e));
    }

/*

    @Test
    public void doDeleteTest(){

        }

*/


}
