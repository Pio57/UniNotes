package Storage.Esame;

import java.util.Date;

public class EsameBean {
    private String nome,nomeProfessore;
    private float voto;
    private int cfu,id;
    private Date data;

    public EsameBean(String nome,String nomeProfessore,float voto,int cfu,Date data,int id){
        this.nome=nome;
        this.nomeProfessore=nomeProfessore;
        this.voto=voto;
        this.cfu=cfu;
        this.data=data;
        this.id=id;
    }

    public EsameBean(String nome,String nomeProfessore,float voto,int cfu,Date data){
        this.nome=nome;
        this.nomeProfessore=nomeProfessore;
        this.voto=voto;
        this.cfu=cfu;
        this.data=data;
    }

    public EsameBean(){    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeProfessore() {
        return nomeProfessore;
    }

    public void setNomeProfessore(String nomeProfessore) {
        this.nomeProfessore = nomeProfessore;
    }

    public float getVoto() {
        return voto;
    }

    public void setVoto(float voto) {
        this.voto = voto;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
