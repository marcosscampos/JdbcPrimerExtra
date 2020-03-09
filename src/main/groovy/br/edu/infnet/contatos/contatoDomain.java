package br.edu.infnet.contatos;

import java.util.List;
import java.util.Scanner;

public class contatoDomain {
    Contato contato = new Contato();
    ContatoDAO dao = new ContatoDAO();
    Scanner ler = new Scanner(System.in);

    public void inserir() {
        try {
            System.out.print("Digite seu nome: ");
            contato.setName(ler.nextLine());

            System.out.print("Digite seu email: ");
            contato.setEmail(ler.nextLine());

            System.out.print("Digite seu telefone: ");
            contato.setFone(ler.nextLine());

            dao.inserir(contato);

            System.out.println("Contato adicionado com sucesso!");
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Não foi possível incluir um contato.");
        }
    }

    public void listar() {
        List<Contato> lista = dao.listar();
        for (Contato cont : lista) {
            System.out.println(
                    "\n\t\tContato (" + cont.getId() + ")" + " \nNOME: " +
                            cont.getName() + "\nEMAIL: " +
                            cont.getEmail() + "\nTELEFONE: " +
                            cont.getFone());
        }
    }

    public void excluir() {
        try {
            System.out.println("Contatos: ");
            listar();

            System.out.print("\nDigite o id do contato: ");
            contato.setId(ler.nextInt());

            dao.excluir(contato);

            System.out.println("\nExcluído com sucesso!");
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Não foi possível excluir o contato.");
        }
    }

    public void alterar() {
        System.out.println("Contatos: ");
        listar();

        try {
            System.out.print("Digite o id do contato: ");
            contato.setId(Integer.parseInt(ler.nextLine()));

            System.out.print("Digite o nome: ");
            contato.setName(ler.nextLine());

            System.out.print("Digite o email: ");
            contato.setEmail(ler.nextLine());

            System.out.print("Digite o telefone: ");
            contato.setFone(ler.nextLine());

            dao.alterar(contato);

            System.out.println("\nContato alterado com sucesso!");
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Não foi possível alterar o contato.");
        }
    }

    public void obterPorId() {
        System.out.print("Digite o id do contato: ");
        int temp = Integer.parseInt(ler.nextLine());

        Contato resultado = dao.obter(temp);

        if (resultado.getName() != null && resultado.getEmail() != null && resultado.getFone() != null) {
            System.out.println("Id: " + temp);
            System.out.println("Nome: " + resultado.getName());
            System.out.println("Email: " + resultado.getEmail());
            System.out.println("Telefone: " + resultado.getFone() + "\n");
        } else {
            System.out.println("Não é possível obter o contato vazio.\n");
        }
    }
}

