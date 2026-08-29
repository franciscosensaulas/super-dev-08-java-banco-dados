package br.com.proway.protify.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    // private é algo que pertence somente a classe
    // static é algo que existe durante todo a execução da aplicação, 
    // fica em memória
    // final não permite alterar o valor (mesma coisa que const do js)
    private static final String URL = "jdbc:postgresql://localhost:5432/protify";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "proway";
    
    public static Connection abrir() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
