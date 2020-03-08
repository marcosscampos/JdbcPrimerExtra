package br.edu.infnet.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
    private FabricaDeConexoes() {
    }

    public static Connection conectar() {
        Connection retorno = null;

        try {
            //1º - Carregar o driver na memória
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2º - Parametrizar a conexão
            String url = "jdbc:mysql://127.0.0.1:3306/desenvolvimento?useTimezone=true&serverTimezone=UTC";
            String usr = "root";
            String pwd = "";

            //3º - Conectar
            retorno = DriverManager.getConnection(url, usr, pwd);

            //4º - Obter dados da conexão (Opcional por enquanto)
            /* DatabaseMetaData databaseMetaData = retorno.getMetaData();

            System.out.println("Banco de dados conectado => " + databaseMetaData.getDatabaseProductName());
            System.out.println("Versão \t\t\t\t\t => " + databaseMetaData.getDatabaseProductVersion() + "\n\n"); */

        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO: Driver não encontrado.");
        } catch (SQLException ex) {
            System.out.println("ERRO: Não foi possível conectar.");
            //ex.printStackTrace();
        }

        return retorno;
    }

    public static void main(String[] args) {
        FabricaDeConexoes.conectar();
    }
}
