package br.com.proway.protify.dao;

import br.com.proway.protify.conexao.Conexao;
import br.com.proway.protify.modelo.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * DAO = Data Access Object Conecentra todo o SQL da tabela "generos" em um só
 * lugar.
 *
 * Statement => SQL fixo, sem parâmetros vindos do usuário PreparedStatement =>
 * SQL com parâmetros (?), protege contra SQL Injection e converte os tipos JAVA
 * -> SQL automaticamente.
 */

public class GeneroDAO {

    //    CRUD, create (insert), read (select), update (update), delete (delete)
    public void inserir(Genero genero) throws SQLException {
        String sql = "INSERT INTO generos (nome) VALUES (?)";

        try (Connection conexao = Conexao.abrir()) {
            PreparedStatement executor = conexao.prepareStatement(sql);
            executor.setString(1, genero.getNome());
            executor.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM generos WHERE id = ?";

        try (Connection conexao = Conexao.abrir()) {
            PreparedStatement executor = conexao.prepareStatement(sql);
            executor.setInt(1, id);

            executor.executeUpdate();
        }
    }

    public void editar(Genero genero) throws SQLException {
        String sql = "UPDATE generos SET nome = ? WHERE id = ?";

        try (Connection conexao = Conexao.abrir()) {
            PreparedStatement executor = conexao.prepareStatement(sql);
            executor.setString(1, genero.getNome());
            executor.setInt(2, genero.getId());
            executor.executeUpdate();
        }
    }

    public ArrayList<Genero> consultarTodos() throws SQLException {
        String sql = "SELECT id, nome FROM generos";
        try (Connection conexao = Conexao.abrir()) {
            Statement executor = conexao.createStatement();
            executor.execute(sql);

            // Tabela em memória armazenando os dados que vieram da consulta do BD
            ResultSet dados = executor.getResultSet();

            ArrayList<Genero> generos = new ArrayList<>();
            // Percorre cada registro da consulta
            while (dados.next()) {
                // Instancia um objeto da classe Genero
                Genero genero = new Genero();
                // Atribui o id com o id da tabela de generos (consulta)
                genero.setId(dados.getInt(1));
                genero.setNome(dados.getString(2));
                // Adiciona o genero na lista de generos
                generos.add(genero);
            }
            return generos;
        }
    }
}
