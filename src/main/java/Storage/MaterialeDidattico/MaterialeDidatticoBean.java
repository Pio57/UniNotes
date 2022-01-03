package Storage.MaterialeDidattico;

public class MaterialeDidatticoBean {

    private int id;
    private String nome;
    private String pathFile;

    public MaterialeDidatticoBean(){}

    public MaterialeDidatticoBean(String nome, String pathFile){
        this.nome = nome;
        this.pathFile = pathFile;
    }

    public MaterialeDidatticoBean(int id,String nome, String pathFile){
        this.id = id;
        this.nome = nome;
        this.pathFile = pathFile;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
