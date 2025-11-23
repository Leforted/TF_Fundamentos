public class Agenda {
    private final Consulta[] consultas;
    private int index;

    public Agenda(){
        this.consultas = new Consulta[40];
        this.index = 0;
    }

    public int getIndex(){
        return index;
    }

    public boolean adicionarConsulta(Consulta consulta){
        if (index == 40) return false;
        if (!consulta.getData().isValidDate()) return false;

        this.consultas[index] = consulta;
        this.index++;
        return true;
    }

    public int buscarPosicao(int numeroConsulta) {
        int position = -1;
        for (int i = 0; i < this.index; i++) {
            if (consultas[i].getNro() == numeroConsulta) position = i;
        }
        return position;
    }

    public Consulta buscarConsultaPorNumero(int numeroConsulta) {
        int position = buscarPosicao(numeroConsulta);
        return (position != -1) ? consultas[position] : null;
    }

    public boolean removerConsulta(int numeroConsulta) {
        int position = buscarPosicao(numeroConsulta);
        if (position == -1) return false;

        for (int i = position; i < this.index - 1; i++) {
            consultas[i] = consultas[i + 1];
        }
        consultas[index - 1] = null;
        this.index--;
        return true;
    }

    public Consulta[] buscarConsultaMedico(String nomeMedico) {
        int quantidadeDeConsultas = 0;
        int crm = 0;

        for (int i = 0; i < this.index; i++) {
            Medico medico = consultas[i].getMedico();
            if (medico.getNome().equalsIgnoreCase(nomeMedico)) {
                crm = medico.getCrm();
                break;
            }
        }

        if (crm == 0) return new Consulta[0];

        for (int i = 0; i < this.index; i++) {
            if (consultas[i].getMedico().getCrm() == crm) quantidadeDeConsultas++;
        }

        Consulta[] consultasMedico = new Consulta[quantidadeDeConsultas];
        if (quantidadeDeConsultas == 0) return consultasMedico;

        int indexConsulta = 0;
        for (int i = 0; i < this.index; i++) {
            if (consultas[i].getMedico().getCrm() == crm){
                consultasMedico[indexConsulta] = consultas[i];
                indexConsulta++;
            }
        }

        return consultasMedico;
    }

    public Consulta buscarConsultaPaciente(int codigo) {
        Consulta primeiraConsultaDoPaciente = null;
        for (int i = 0; i < this.index; i++) {
            if (consultas[i].getPaciente().getCodigo() == codigo) {
                primeiraConsultaDoPaciente = consultas[i];
                break;
            }
        }
        return primeiraConsultaDoPaciente;
    }

    public Consulta[] buscarConsultaData(int dia, int mes, int ano) {
        int quantidadeDeConsultas = 0;

        for (int i = 0; i < this.index; i++) {
            Data data = consultas[i].getData();
            if (data.getDia() == dia && data.getMes() == mes && data.getAno() == ano) {
                quantidadeDeConsultas++;
            }
        }

        Consulta[] consultasFiltradas = new Consulta[quantidadeDeConsultas];
        int indexConsulta = 0;

        for (int i = 0; i < this.index; i++) {
            Data data = consultas[i].getData();
            if (data.getDia() == dia && data.getMes() == mes && data.getAno() == ano) {
                consultasFiltradas[indexConsulta] = consultas[i];
                indexConsulta++;
            }
        }

        return consultasFiltradas;
    }

    public double buscarValorConsultasPorEspecialidadeMedica(String especialidade) {
        double valorTotal = 0;
        for (int i = 0; i < this.index; i++) {
            String especialidadeMedico = consultas[i].getMedico().getEspecialidade();
            double valor = consultas[i].getValor();
            if (especialidadeMedico.equalsIgnoreCase(especialidade)) valorTotal += valor;
        }
        return valorTotal;
    }

    public boolean alterarMedico(int numeroConsulta, Medico medico) {
        Consulta consulta = buscarConsultaPorNumero(numeroConsulta);
        if (consulta == null) return false;
        consulta.setMedico(medico);
        return true;
    }

    public Consulta buscarConsultaMaisBarata(){
        if (index == 0) return null;
        Consulta consultaMenorValor = consultas[0];
        for (int i = 0; i < this.index; i++) {
            if (consultas[i].getValor() < consultaMenorValor.getValor()){
                consultaMenorValor = consultas[i];
            }
        }
        return consultaMenorValor;
    }

    public void mostraAgenda() {
        if (this.index == 0) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }

        for (int i = 0; i < this.index; i++) {
            System.out.println(consultas[i]);
        }
    }

}
