package Model.Corso;

import Model.MaterialeDidattico.MaterialeDidatticoBean;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CorsoBean {

    private int id;
    private String nome;
    private String descrizione;
    private String nomeProfessore;
    private ArrayList<MaterialeDidatticoBean> listaMateriale;

    public CorsoBean(){}

    public CorsoBean(String nome,String descrizione,String nomeProfessore){
        this.nome = nome;
        this.descrizione = descrizione;
        this.nomeProfessore = nomeProfessore;
    }

    public CorsoBean(String nome,String descrizione,String nomeProfessore, ArrayList<MaterialeDidatticoBean> listaMateriale){
        this.nome = nome;
        this.descrizione = descrizione;
        this.nomeProfessore = nomeProfessore;
        this.listaMateriale = listaMateriale;
    }

    public CorsoBean(int id,String nome,String descrizione,String nomeProfessore, ArrayList<MaterialeDidatticoBean> listaMateriale){
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.nomeProfessore = nomeProfessore;
        this.listaMateriale = listaMateriale;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getNomeProfessore() {
        return nomeProfessore;
    }

    public ArrayList<MaterialeDidatticoBean> getListaMateriale() {
        return listaMateriale;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setNomeProfessore(String nomeProfessore) {
        this.nomeProfessore = nomeProfessore;
    }

    public void setListaMateriale(ArrayList<MaterialeDidatticoBean> listaMateriale) {
        this.listaMateriale = listaMateriale;
    }
}
