package Storage.Esame;

import java.time.LocalDate;

/**
 * Questa classe rappresenta un Esame.
 * Un esame possiede un nome, un voto, il cfu,
 * il nome del professore che ha condotto l'esame,
 * l'id del esame e la data in qui è stato sostenuto
 * l'esame.
 */

public class EsameBean {
    private String nome,nomeProfessore;
    private float voto;
    private int cfu,id;
    private LocalDate data;

    /**
     * Metodo che stampa un stringa con tutte le informazioni
     * @return la stringa con le informazioni di un esame
     */

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

    /**
     * Costruttore di EsameBean
     * @param nome è il nome del esame sostenuto
     * @param nomeProfessore è il nome del professore
     * che ha condotto l'esame
     * @param voto è il voto che lo studente ha ottenuto dall'esame
     * @param cfu è il credito che da tale esame
     * @param data è la data in cui lo studente ha sostenuto l'esame
     * @param id è l'id dell'esme
     */
    public EsameBean(String nome, String nomeProfessore, float voto, int cfu, LocalDate data, int id){
        this.nome=nome;
        this.nomeProfessore=nomeProfessore;
        this.voto=voto;
        this.cfu=cfu;
        this.data=data;
        this.id=id;
    }
    /**
     * Costruttore di EsameBean
     * @param nome è il nome del esame sostenuto
     * @param nomeProfessore è il nome del professore
     * che ha condotto l'esame
     * @param voto è il voto che lo studente ha ottenuto dall'esame
     * @param cfu è il credito che da tale esame
     * @param data è la data in cui lo studente ha sostenuto l'esame
     */
    public EsameBean(String nome,String nomeProfessore,float voto,int cfu,LocalDate data){
        this.nome=nome;
        this.nomeProfessore=nomeProfessore;
        this.voto=voto;
        this.cfu=cfu;
        this.data=data;
    }

    /**
     * Costruttore di EsameBean
     */
    public EsameBean(){    }

    /**
     * Metodo che restituisce il nome dell'esame
     * @return il nome dell'esame
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo che setta il nome di un Esame
     * @param nome è il nome di un esame
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo che restituisce il nome del professore
     * che ha che ha condotto l'esame
     * @return nome del professore che ha condotto l'esame
     */
    public String getNomeProfessore() {
        return nomeProfessore;
    }

    /**
     * Metodo che setta il nome del professore che ha condotto l'esame
     * @param nomeProfessore è il nome del professore che ha condotto l'esame
     */
    public void setNomeProfessore(String nomeProfessore) {
        this.nomeProfessore = nomeProfessore;
    }

    /**
     * Metodo che restituisce il voto
     * @return il voto ottenuto dall'esame
     */
    public float getVoto() {
        return voto;
    }

    /**
     * Metodo che setta il voto
     * @param voto è il voto ottenuto dall'esame
     */
    public void setVoto(float voto) {
        this.voto = voto;
    }

    /**
     * Metodo che restituisce il Cfu
     * @return il cfu di un esame
     */
    public int getCfu() {
        return cfu;
    }

    /**
     * Metodo che setta il cfu
     * @param cfu è il credito che da tale esame
     */
    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    /**
     * Metodo che restituisce l'id di un esame
     * @return l'id di un esame
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo che setta l'id di un esame
     * @param id è l'id di un esame
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo che restituisce la data in cui
     * lo studente ha sostenuto l'esame
     * @return la data in cui lo studente ha sostenuto l'esame
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Metodo che settala data in cui
     * lo studente ha sostenuto l'esame
     * @param data è la data in cui lo studente ha sostenuto l'esame
     */
    public void setData(LocalDate data) {
        this.data = data;
    }
}
