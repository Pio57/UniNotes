import Application.Corso.ServiceCorso.CorsoServiceImpl;
import Application.MaterialeDidattico.ServiceMaterialeDidattico.MaterialeDidatticoServiceImpl;
import Storage.Corso.CorsoBean;
import Storage.Corso.CorsoDao;
import Storage.MaterialeDidattico.MaterialeDidatticoBean;
import Storage.MaterialeDidattico.MaterialeDidatticoDao;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MaterialeDaoTest {
        private MaterialeDidatticoDao materialeDAO;
        private MaterialeDidatticoServiceImpl materialeService;

        @Before
        public void setUp() {
            materialeDAO = new MaterialeDidatticoDao();
            materialeService = new MaterialeDidatticoServiceImpl();
        }

        @Test
        public void doRetrieveByIdTest(){
            int id=9;
            MaterialeDidatticoBean m = materialeDAO.doRetriveById(id);
            assertEquals(id, m.getId());
        }

        @Test
        public void doRetrieveByIdUtenteTest(){
            int id=2;
            ArrayList<MaterialeDidatticoBean> list = materialeDAO.doRetriveAllByIdUtente(id);
            int size = list.size();
            assertEquals(size, list.size());
        }

        @Test
        public void doRetrieveByIdCorsoTest(){
            int id=1;
            ArrayList<MaterialeDidatticoBean> list = materialeDAO.doRetriveAllByIdUtente(id);
            int size = list.size();
            assertEquals(size, list.size());
        }

        @Test
        public void doRetriveAllTest(){
            ArrayList<MaterialeDidatticoBean> list = materialeDAO.doRetriveAll();
            int size = list.size();
            assertEquals(size, list.size());
        }

        @Test
        public void doSaveTest(){
            MaterialeDidatticoBean m = new MaterialeDidatticoBean();
            m.setNome("provaNomeMateriale");
            m.setPathFile("provaPathMateriale");
            assertEquals(true,materialeDAO.doSave(m, 7, 2));
        }

        @Test
        public void doUpdateTest(){
            MaterialeDidatticoBean m = new MaterialeDidatticoBean();
            m.setId(6);
            m.setNome("provaNomeM");
            m.setPathFile("provaPathM");
            assertEquals(true,materialeDAO.doUpdate(m));
        }
        /*

    @Test
    public void doDeleteTest(){

    }

*/
}
