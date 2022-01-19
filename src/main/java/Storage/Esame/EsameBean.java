package Storage.Esame;

import java.time.LocalDate;

public class EsameBean {
    private String nome,nomeProfessore;
    private float voto;
    private int cfu,id;
    private LocalDate data;

    @Override
    public String toString() {
        return "EsameBean{" +
                "nome='" + nome + '\'' +
                ", nomeProfessore='" + nomeProfessore + '\'' +
                ", voto=" + voto +
                ", cfu=" + cfu +
                ", id=" + id +
                ", data=" + data +
                '}';
    }

    public EsameBean(String nome, String nomeProfessore, float voto, int cfu, LocalDate data, int id){
        this.nome=nome;
        this.nomeProfessore=nomeProfessore;
        this.voto=voto;
        this.cfu=cfu;
        this.data=data;
        this.id=id;
    }

    public EsameBean(String nome,String nomeProfessore,float voto,int cfu,LocalDate data){
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
