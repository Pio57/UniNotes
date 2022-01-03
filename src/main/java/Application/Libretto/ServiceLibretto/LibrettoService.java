package Application.Libretto.ServiceLibretto;


import Storage.Libretto.LibrettoBean;

import java.util.ArrayList;

public interface LibrettoService {


    public ArrayList<LibrettoBean> visualizzaLibretto();

    public LibrettoBean visualizzaLibretto(int id);

    public LibrettoBean inserisciLibretto(int ne, int cc, float media);

    public LibrettoBean eliminaLibretto(LibrettoBean l);

    public LibrettoBean modificaLibretto(LibrettoBean l);

}
