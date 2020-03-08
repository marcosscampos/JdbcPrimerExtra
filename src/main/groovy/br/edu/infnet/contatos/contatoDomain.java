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
                    cont.getId() + " - " +
                            cont.getName() + " - email => " +
                            cont.getEmail() + " - telefone => " +
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

            System.out.println("Excluído com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível excluir o contato.");
        }
    }

    public void alterar() {
        System.out.println("Contatos: ");
        listar();

        System.out.print("Digite o id do contato: ");
        contato.setId(ler.nextInt());

        System.out.print("Digite o nome: ");
        contato.setName(ler.nextLine());

        System.out.print("Digite o email: ");
        contato.setEmail(ler.next());

        System.out.print("Digite o telefone: ");
        contato.setFone(ler.nextLine());

        dao.alterar(contato);

        listar();
    }

    public void obterPorId() {
        System.out.print("Digite o id do contato: ");
        int temp = ler.nextInt();

        Contato resultado = dao.obter(temp);
        System.out.println("Nome: " + resultado.getName());
        System.out.println("Email: " + resultado.getEmail());
        System.out.println("Telefone: " + resultado.getFone());
    }
}

