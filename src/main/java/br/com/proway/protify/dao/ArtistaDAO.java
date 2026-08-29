package br.com.proway.protify.dao;

import br.com.proway.protify.conexao.Conexao;
import br.com.proway.protify.modelo.Artista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArtistaDAO {

    public void inserir(Artista artista) throws SQLException {
        String sql = """
            INSERT INTO artistas (nome, pais, ano_estreia, ativo) 
            VALUES (?, ?, ?, ?)""";
        try (Connection conexao = Conexao.abrir()) {
            PreparedStatement executor = conexao.prepareStatement(sql);
            executor.setString(1, artista.getNome());
            executor.setString(2, artista.getPais());
            executor.setInt(3, artista.getAnoEstreia());
            executor.setBoolean(4, artista.isTrabalhando());
            executor.executeUpdate();
        }
    }

    public ArrayList<Artista> consultarTodos() throws SQLException {
        String sql = "SELECT id, nome, pais, ano_estreia, ativo FROM artistas ORDER BY nome";
        try (Connection conexao = Conexao.abrir()) {
            Statement executor = conexao.createStatement();
            executor.execute(sql);

            ResultSet dados = executor.getResultSet();

            ArrayList<Artista> artistas = new ArrayList<>();
            while (dados.next()) {
                Artista artista = new Artista();
                artista.setId(dados.getInt(1));
                artista.setNome(dados.getString(2));
                artista.setPais(dados.getString(3));
                artista.setAnoEstreia(dados.getInt(4));
                artista.setTrabalhando(dados.getBoolean(5));

                artistas.add(artista);
            }
            return artistas;
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM artistas WHERE id = ?";
        try (Connection conexao = Conexao.abrir()) {
            PreparedStatement executor = conexao.prepareStatement(sql);
            executor.setInt(1, id);
            executor.executeUpdate();
        }
    }

    public void editar(Artista artista) throws SQLException {
        String sql = "UPDATE artistas SET nome=?, pais=?, ano_estreia=?, ativo=? WHERE id=?";
        try(Connection conexao = Conexao.abrir()){
            PreparedStatement executor = conexao.prepareStatement(sql);
            executor.setString(1, artista.getNome());
            executor.setString(2, artista.getPais());
            executor.setInt(3, artista.getAnoEstreia());
            executor.setBoolean(4, artista.isTrabalhando());
            executor.setInt(5, artista.getId());
            executor.executeUpdate();
        }
    }
}
