public class Medico {
    private int crm;
    private String nome;
    private String especialidade;

    public Medico(){
        this.crm = 0;
        this.nome = null;
        this.especialidade = null;
    }

    public Medico(int crm, String nome, String especialidade){
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getCrm(){
        return this.crm;
    }
    public String getNome(){
        return this.nome;
    }
    public String getEspecialidade(){
        return this.especialidade;
    }

    public void setCrm(int crm){
        this.crm = crm;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    
    @Override
    public String toString() {
        return "Médico [CRM=" + crm + ", Nome=" + nome + ", Especialidade=" + especialidade + "]";
    }


}
