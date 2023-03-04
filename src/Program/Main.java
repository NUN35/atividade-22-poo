package Program;

import Entities.Registry;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private ArrayList<Registry> lista = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Iniciando o software...");
        boolean exec = true;
        Main main = new Main();
        main.selecionarOpcao(exec, main);
    }

    private void selecionarOpcao(boolean exec, Main main) {
        while (exec) {
            main.mostrarMenu();
            int opcao = this.sc.nextInt();

            switch (opcao) {
                case 1:
                    main.adicionarVeiculo();
                    break;

                case 2:
                    main.removerVeiculo();
                    break;

                case 3:
                    main.listarVeiculo();
                    break;

                case 4:
                    exec = false;
                    System.out.println("Programa fechando...");
                    break;

                default:
                    System.err.println("Opção invalida!!!");
                    break;
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("1 - Adicionar");
        System.out.println("2 - Retirar");
        System.out.println("3 - Lista");
        System.out.println("4 - Fechar Programa");
    }

    private void listarVeiculo() {
        for (Registry registro : this.lista) {
            System.out.println(registro);
        }
    }

    private void removerVeiculo() {
        listarVeiculo();
        System.out.print("Informe a placa do veiculo para retirada: ");
        String buscaPlaca = sc.nextLine();
        Registry reg = null;

        reg = verificaSeJaExisteNoEstacionamento(buscaPlaca);

        if (reg == null) {
            System.err.println("Registro nao encontrado!!!");
        } else {
            System.out.println("Deseja remover o veiculo do estacionamento? 1 - sim / 2 - não");
            int confirmacao = sc.nextInt();

            if (confirmacao == 1) {
                reg.setHora_saida(new Date());
                reg.calcularValor();
                System.out.println(reg);
                lista.remove(reg);
            } else if (confirmacao == 2) {
                return;
            } else {
                System.out.println("Opção invalidda");
            }
        }
    }

    private void adicionarVeiculo() {
        System.out.print("Informe a placa: ");
        String placa = sc.nextLine();
        Registry registry = new Registry(placa, new Date());

        Registry registrado = verificaSeJaExisteNoEstacionamento(placa);

        if (registrado == null) {
            this.lista.add(registry);
        } else {
            System.err.println("Placa ja consta no sistema!");
        }
    }

    private Registry verificaSeJaExisteNoEstacionamento(String placa) {
        for (Registry reg : this.lista) {
            if (reg.getPlaca().equalsIgnoreCase(placa)) {
                return reg;
            }
        }
        return null;
    }

}
