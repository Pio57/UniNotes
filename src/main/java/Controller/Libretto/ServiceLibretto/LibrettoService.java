package Controller.Libretto.ServiceLibretto;

import Model.Esame.EsameBean;
import Model.Libretto.LibrettoBean;
import Model.Libretto.LibrettoDao;

import java.util.ArrayList;
import java.util.Date;

public interface LibrettoService {


    public ArrayList<LibrettoBean> visualizzaLibretto();

    public LibrettoBean visualizzaLibretto(int id);

    public LibrettoBean inserisciLibretto(int ne, int cc, float media);

    public LibrettoBean eliminaLibretto(LibrettoBean l);

    public LibrettoBean modificaLibretto(LibrettoBean l);

}
