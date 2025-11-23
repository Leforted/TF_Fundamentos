public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public static boolean ehAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public boolean isValidDate() {
        if (this.dia < 1 || this.mes < 1 || this.ano < 1 || this.mes > 12) return false;

        int maxNumberDay = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> ehAnoBissexto(this.ano) ? 29 : 28;
            default -> 0;
        };

        return this.dia <= maxNumberDay;
    }

    @Override
    public String toString() {
        String dd = (dia < 10 ? "0" + dia : "" + dia);
        String mm = (mes < 10 ? "0" + mes : "" + mes);
        return dd + "/" + mm + "/" + ano;
    }

}
