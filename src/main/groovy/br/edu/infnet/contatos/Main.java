package br.edu.infnet.contatos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        contatoDomain cd = new contatoDomain();
        Scanner ler = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Bem vindo ao cadastro de contatos!" +
                    " \nO que deseja fazer?");
            System.out.println(
                    "1 - Cadastrar" +
                            "\n2 - Listar" +
                            "\n3 - Alterar" +
                            "\n4 - Excluir" +
                            "\n5 - Pesquisar" +
                            "\n6 - Sair");
            System.out.print("=> ");
            switch (ler.next()) {
                case "1": {
                    cd.inserir();
                }
                case "2": {
                    cd.listar();
                    break;
                }
                case "3": {
                    cd.alterar();
                    break;
                }
                case "4": {
                    cd.excluir();
                    break;
                }
                case "5": {
                    cd.obterPorId();
                    break;
                }
                case "6": {
                    System.out.println("Até logo!");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Operação inválida.");
                }
            }

            System.out.println("Deseja fazer outra operação? S/N");
            opcao = ler.next();
        } while (opcao.toLowerCase().equals("s"));
    }
}
