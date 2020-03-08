package br.edu.infnet.contatos;

import br.edu.infnet.jdbc.FabricaDeConexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    public void inserir(Contato contato) {

        try (Connection con = FabricaDeConexoes.conectar()) {

            String sql = "INSERT INTO contacts" +
                    " (name, email, fone)" +
                    " values(?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, contato.getName());
            ps.setString(2, contato.getEmail());
            ps.setString(3, contato.getFone());
            ps.executeUpdate();
            ps.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Contato> listar() {

        List<Contato> retorno = new ArrayList<>();

        try (Connection con = FabricaDeConexoes.conectar()) {

            Statement statement = con.createStatement();
            String sql = "SELECT id, name, email, fone" +
                    " FROM contacts" +
                    " ORDER BY id";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setName(rs.getString("name"));
                contato.setEmail(rs.getString("email"));
                contato.setFone(rs.getString("fone"));
                retorno.add(contato);

            }
        } catch (Exception e) {
            //e.printStackTrace(); - Pra caso queira debugar vendo o erro completo.
            System.out.println("Não foi possível listar os contatos.");
        }

        return retorno;
    }

    public void excluir(Contato contato) {

        try (Connection con = FabricaDeConexoes.conectar()) {

            String sql = "DELETE FROM contacts" +
                    " WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, contato.getId());
            ps.executeUpdate();
            ps.close();

        } catch (Exception ex) {
            System.out.println("Não foi possível excluir o contato.");
            //ex.printStackTrace();
        }
    }

    public void alterar(Contato contato) {
        try (Connection con = FabricaDeConexoes.conectar()) {

            String sql = "UPDATE contacts" +
                    " SET name = ?, email = ?, fone = ? " +
                    "WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, contato.getName());
            ps.setString(2, contato.getEmail());
            ps.setString(3, contato.getFone());
            ps.executeUpdate();
            ps.close();

            System.out.println("Contato: " + contato.getName());
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Não foi possível alterar os dados do contato.");
        }
    }

    public Contato obter(int id) {
        List <Contato> contatos = new ArrayList<>();
        Contato contato = new Contato();

        try (Connection con = FabricaDeConexoes.conectar()) {
            String sql = "SELECT name, email, fone FROM contacts WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                contato.setName(rs.getString("name"));
                contato.setEmail(rs.getString("email"));
                contato.setFone(rs.getString("fone"));
                contatos.add(contato);
            }
            statement.close();

        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Não foi possível obter as informações do contato.");
        }
        return contato;
    }
}
