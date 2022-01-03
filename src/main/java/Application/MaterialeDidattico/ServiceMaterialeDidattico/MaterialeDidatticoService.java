package Application.MaterialeDidattico.ServiceMaterialeDidattico;

import Storage.MaterialeDidattico.MaterialeDidatticoBean;

import java.util.ArrayList;

public interface MaterialeDidatticoService {

    public boolean inserireMateriale(String nome,String pathFile , int idCorso,int idUtente);//qui ho aggiunto un parametro in più , e ho campbiato il valore di ritorno in un booleano


    public boolean eliminaMateriale(int id);
    /*
        public ArrayList<MaterialeDidatticoBean> eliminaMateriale(MaterialeDidatticoBean m, CorsoBean c);

    */
    public MaterialeDidatticoBean modificaMateriale(MaterialeDidatticoBean m);


    public MaterialeDidatticoBean visualizza(int id);

    public ArrayList<MaterialeDidatticoBean> visualizzaTutti();

}
