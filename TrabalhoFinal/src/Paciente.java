public class Paciente {
    private int codigo;
    private String nome;

    public Paciente(){
        this.codigo = 0;
        this.nome = null;
    }
    public Paciente(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo(){
        return this.codigo;
    }
    public String getNome(){
        return this.nome;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cód: " + codigo + " - Nome: " + nome;
    }
}
