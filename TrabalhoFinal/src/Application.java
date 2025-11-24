import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcao;
        int numeroConsulta = 1;

        do {
            System.out.println("1 – Incluir consulta");
            System.out.println("2 – Remover consulta");
            System.out.println("3 – Mostrar consultas");
            System.out.println("4 – Consultas de um médico");
            System.out.println("5 – Data da consulta de um paciente");
            System.out.println("6 – Consultas por data");
            System.out.println("7 – Valor das consultas por especialidade médica");
            System.out.println("8 – Alterar médico da consulta");
            System.out.println("9 – Consulta com o menor valor cobrado");
            System.out.println("10 – Sair do programa");
            System.out.print("Opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1: {
                    if (agenda.getIndex() == 40) {
                        System.out.println();
                        System.out.println("A agenda está lotada!");
                        System.out.println();
                        continue;
                    }
                    System.out.println();
                    System.out.print("Dia: ");
                    int dia = sc.nextInt();
                    System.out.print("Mês: ");
                    int mes = sc.nextInt();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();

                    Data data = new Data(dia, mes, ano);
                    if (!data.isValidDate()) {
                        System.out.println();
                        System.out.println("Data inválida");
                        System.out.println();
                        sc.nextLine();
                        continue;
                    }

                    System.out.print("CRM do médico: ");
                    int crm = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome do médico: ");
                    String nomeMedico = sc.nextLine();
                    System.out.print("Especialidade do médico: ");
                    String especialidade = sc.nextLine();
                    Medico medico = new Medico(crm, nomeMedico, especialidade);

                    System.out.print("Nome paciente: ");
                    String nomePaciente = sc.nextLine();
                    System.out.print("Código do paciente: ");
                    int codigoPaciente = sc.nextInt();
                    Paciente paciente = new Paciente(codigoPaciente, nomePaciente);

                    System.out.print("Valor da consulta: ");
                    double valor = sc.nextDouble();

                    agenda.adicionarConsulta(new Consulta(numeroConsulta, data, medico, paciente, valor));
                    numeroConsulta++;
                    sc.nextLine();

                    System.out.println();
                    System.out.println("Consulta Adicionada com Sucesso!");
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.print("Número da consulta: ");
                    int numero = sc.nextInt();
                    sc.nextLine();
                    if (!agenda.removerConsulta(numero)) {
                        System.out.println();
                        System.out.println("Consulta não encontrada.");
                        System.out.println();
                        continue;
                    }
                    System.out.println("Consulta removida!");
                    break;
                }
                case 3: {
                    agenda.mostraAgenda();
                    break;
                }
                case 4: {
                    System.out.println();
                    System.out.print("Nome do médico: ");
                    String nome = sc.nextLine();
                    Consulta[] consultas = agenda.buscarConsultaMedico(nome);
                    if (consultas.length == 0) {
                        System.out.println("Não há consultas para esse médico.");
                        continue;
                    }
                    for (int i = 0; i < consultas.length; i++) {
                        System.out.println(consultas[i]);
                    }
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println();
                    System.out.print("Código do paciente: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    Consulta consulta = agenda.buscarConsultaPaciente(codigo);

                    if (consulta == null) {
                        System.out.println();
                        System.out.println("Paciente não tem consultas agendadas");
                        System.out.println();
                        continue;
                    }

                    System.out.println("Data da consulta:");
                    System.out.println(consulta.getData());
                    break;
                }
                case 6: {
                    System.out.println();
                    System.out.print("Dia: ");
                    int dia = sc.nextInt();
                    System.out.print("Mês: ");
                    int mes = sc.nextInt();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    sc.nextLine();

                    Data data = new Data(dia, mes, ano);
                    if (!data.isValidDate()) {
                        System.out.println();
                        System.out.println("Data inválida");
                        System.out.println();
                        continue;
                    }

                    Consulta[] consultas = agenda.buscarConsultaData(dia, mes, ano);

                    if (consultas.length == 0) {
                        System.out.println();
                        System.out.println("Não há consultas nessa data");
                        System.out.println();
                        continue;
                    }

                    for (int i = 0; i < consultas.length; i++) {
                        System.out.println(consultas[i]);
                    }
                    break;
                }
                case 7: {
                    System.out.println();
                    System.out.print("Especialidade médica: ");
                    String especialidade = sc.nextLine();
                    double valorTotal = agenda.buscarValorConsultasPorEspecialidadeMedica(especialidade);
                    if (valorTotal == 0) {
                        System.out.println("Não há consultas para essa especialidade.");
                        continue;
                    }
                    System.out.println("Valor Total: " + valorTotal);
                    break;
                }
                case 8: {
                    System.out.println();
                    System.out.print("Numero da consulta: ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    if (agenda.buscarConsultaPorNumero(numero) == null) {
                        System.out.println();
                        System.out.println("Consulta não existe");
                        System.out.println();
                        continue;
                    }

                    System.out.print("CRM do médico: ");
                    int crm = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome do médico: ");
                    String nomeMedico = sc.nextLine();
                    System.out.print("Especialidade do médico: ");
                    String especialidade = sc.nextLine();
                    Medico medico = new Medico(crm, nomeMedico, especialidade);

                    agenda.alterarMedico(numero, medico);
                    System.out.println("Médico Alterado!");
                    break;
                }
                case 9: {
                    Consulta consulta = agenda.buscarConsultaMaisBarata();

                    if (consulta == null) {
                        System.out.println();
                        System.out.println("Não há consultas cadastradas");
                        System.out.println();
                        continue;
                    }

                    System.out.println(consulta);

                    break;
                }
                case 10: {
                    System.out.println("Encerrando o programa...");
                    break;
                }
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();

        } while (opcao != 10);

        sc.close();
    }
}
