package Controller.ServiceCorsoServlet;

import Model.Corso.CorsoBean;
import Model.Corso.CorsoDao;
import Model.MaterialeDidattico.MaterialeDidatticoBean;

import java.util.ArrayList;

public interface CorsoService {


    public ArrayList<CorsoBean> visualizzaCorsi();

    public CorsoBean visualizzaCorso(int id);

    public CorsoBean inserisciCorso( String nome, String descrizione,String nomeProfessore); //ho modificato i parametri da passare --> modifira nell' odd


    public boolean eliminaCorso(int idCorso);//qui ho aggiunto l'id per individuare il corso --> modificare nell'odd


    public CorsoBean modificaCorso(int id,String nome, String descrizione,String nomeProfessore);


    public ArrayList<MaterialeDidatticoBean> visualizzaTuttoIlMateriale(int id);
}
