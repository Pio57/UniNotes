package Application.MaterialeDidattico.ServiceMaterialeDidattico;

import Storage.MaterialeDidattico.MaterialeDidatticoBean;
import Storage.MaterialeDidattico.MaterialeDidatticoDao;

import java.util.ArrayList;

public class MaterialeDidatticoServiceImpl implements MaterialeDidatticoService {

    public boolean inserireMateriale(String nome,String pathFile , int idCorso,int idUtente){//qui ho aggiunto un parametro in più , e ho campbiato il valore di ritorno in un booleano
        MaterialeDidatticoBean m = new MaterialeDidatticoBean(nome,pathFile);
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        if( md.doSave(m,idCorso,idUtente))
            return true;
        return false;
    }

    public boolean eliminaMateriale(int id){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doDelate(id);

    }
    /*
        private ArrayList<MaterialeDidatticoBean> eliminaMateriale(MaterialeDidatticoBean m, CorsoBean c){
            MaterialeDidatticoDao md = new MaterialeDidatticoDao();
            md.doDelate(m.getId());
            return md.doRetriveAllByIdUtente(u.getIdUtente());
        }
    */
    public boolean modificaMateriale(int id,String nome,String fileName){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        MaterialeDidatticoBean m = new MaterialeDidatticoBean(id,nome,fileName);
        if(md.doUpdate(m))
            return true;
        return false;
    }

    public MaterialeDidatticoBean visualizza(int id){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doRetriveById(id);
    }

    public ArrayList<MaterialeDidatticoBean> visualizzaTutti(){
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doRetriveAll();
    }

    @Override
    public ArrayList<MaterialeDidatticoBean> visualizzaMaterialeDiUnUtente(int idUtente) {
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doRetriveAllByIdUtente(idUtente);
    }

    @Override
    public ArrayList<MaterialeDidatticoBean> visualizzaMaterialeDiUnCorso(int idCorso) {
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        return md.doRetriveAllByIdCorso(idCorso);
    }

}
