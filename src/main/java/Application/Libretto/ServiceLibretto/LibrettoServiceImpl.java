package Application.Libretto.ServiceLibretto;

import Model.Esame.EsameBean;
import Model.Esame.EsameDao;
import Model.Libretto.LibrettoBean;
import Model.Libretto.LibrettoDao;

import java.util.ArrayList;

public class LibrettoServiceImpl implements LibrettoService {



    public ArrayList<LibrettoBean> visualizzaLibretto(){
        LibrettoDao ld = new LibrettoDao();
        return ld.doRetriveAll();
    }

    public LibrettoBean visualizzaLibretto(int id){
        LibrettoDao lb = new LibrettoDao();
        return lb.doRetriveById(id);
    }

    public LibrettoBean inserisciLibretto(int ne, int cc, float media){
        LibrettoBean l = new LibrettoBean(ne,cc,media);
        LibrettoDao ld = new LibrettoDao();
        if(ld.doSave(l))
            return l;
        return null;
    }

    public LibrettoBean eliminaLibretto(LibrettoBean l){
        LibrettoDao ld = new LibrettoDao();
        if(ld.doDelate(l.getIdLibretto()))
            return l;
        return null;
    }

    public LibrettoBean modificaLibretto(LibrettoBean l){
        LibrettoDao ld = new LibrettoDao();
        if(ld.doUpdate(l))
            return l;
        return null;
    }

}
