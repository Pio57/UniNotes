package Storage.MaterialeDidattico;

/**
 * Questa classe rappresenta il MaterialeDidattico (MaterialeDidatticoBean).
 * Un MaterialeDidattico possiede un id, un nome,
 * e una path del file
 */
public class MaterialeDidatticoBean {

    /**
     * Rappresenta l'id del materiale'.
     */
    private int id;

    /**
     * Rappresenta il nome del materiale'.
     */
    private String nome;

    /**
     * Rappresenta la path materiale'.
     */
    private String pathFile;

    /**
     * Costruttore vuoto.
     */
    public MaterialeDidatticoBean(){}

    /**
     * Costruttore con tutti i parametri tranne id
     * @param nome
     * @param pathFile
     */
    public MaterialeDidatticoBean(String nome, String pathFile){
        this.nome = nome;
        this.pathFile = pathFile;
    }


    /**
     * Costruttore con tutti i parametri
     * @param id
     * @param nome
     * @param pathFile
     */
    public MaterialeDidatticoBean(int id,String nome, String pathFile){
        this.id = id;
        this.nome = nome;
        this.pathFile = pathFile;
    }

    /**
     * Ritorna l'id del materiale
     * @return int id del materiale
     */
    public int getId() {
        return id;
    }

    /**
     * Ritorna il nome del materiale
     * @return string nome del materiale
     */
    public String getNome() {
        return nome;
    }

    /**
     * Ritorna la path del materiale
     * @return string path del materiale
     */
    public String getPathFile() {
        return pathFile;
    }

    /**
     * Set dell'id del materiale.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set del nome del materiale.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Set della path del file del materiale.
     */
    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
