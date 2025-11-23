public class Consulta {
    private int numero;
    private Data data;
    private Medico medico;
    private Paciente paciente;
    private double valor;

    public Consulta(int numero, Data data, Medico medico, Paciente paciente, double valor) {
        this.numero = numero;
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
        this.valor = valor;
    }

    public int getNro() {
        return numero;
    }

    public void setNro(int numero) {
        this.numero = numero;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Consulta [Nro=" + numero +
                ", Data=" + data +
                ", Médico=" + medico +
                ", Paciente=" + paciente +
                ", Valor=R$ " + valor + "]";
    }
}
