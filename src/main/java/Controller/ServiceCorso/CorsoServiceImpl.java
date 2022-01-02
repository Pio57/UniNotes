package Controller.ServiceCorso;

import Model.Corso.CorsoBean;
import Model.Corso.CorsoDao;
import Model.MaterialeDidattico.MaterialeDidatticoBean;

import java.util.ArrayList;

public class CorsoServiceImpl implements CorsoService{


    public ArrayList<CorsoBean> visualizzaCorsi(){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveAll();
    }

    public CorsoBean visualizzaCorso(int id){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveById(id);
    }

    public CorsoBean inserisciCorso( String nome, String descrizione,String nomeProfessore){ //ho modificato i parametri da passare --> modifira nell' odd
        CorsoBean c = new CorsoBean(nome,descrizione,nomeProfessore);
        CorsoDao cd = new CorsoDao();
        if(cd.doSave(c))
            return c;
        return null;
    }

    public boolean eliminaCorso(int idCorso){//qui ho aggiunto l'id per individuare il corso --> modificare nell'odd
        CorsoDao cd = new CorsoDao();
        if(cd.doDelate(idCorso))
            return true;
        return false;
    }

    public CorsoBean modificaCorso(int id,String nome, String descrizione,String nomeProfessore){
        CorsoDao cd = new CorsoDao();
        CorsoBean c = new CorsoBean(id,nome,descrizione,nomeProfessore);
        if(cd.doUpdate(c))
            return c;
        return null;
    }

    public ArrayList<MaterialeDidatticoBean> visualizzaTuttoIlMateriale(int id){
        CorsoDao cd = new CorsoDao();
        return cd.doRetriveById(id).getListaMateriale();
    }

}
