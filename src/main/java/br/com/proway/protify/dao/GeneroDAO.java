package br.com.proway.protify.dao;

import br.com.proway.protify.conexao.Conexao;
import br.com.proway.protify.modelo.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * DAO = Data Access Object
 * Conecentra todo o SQL da tabela "generos" em um só lugar.
 * 
 * Statement         => SQL fixo, sem parâmetros vindos do usuário
 * PreparedStatement => SQL com parâmetros (?), protege contra SQL Injection
 *                      e converte os tipos JAVA -> SQL automaticamente.
 */

public class GeneroDAO {
    //    CRUD, create (insert), read (select), update (update), delete (delete)
    public void inserir(Genero genero) throws SQLException{
        String sql = "INSERT INTO generos (nome) VALUES (?)";
        
        try(Connection conexao = Conexao.abrir()){
            PreparedStatement executor = conexao.prepareStatement(sql);
            executor.setString(1, genero.getNome());
            executor.executeUpdate();
        }
    }
    
    public void delete(int id) throws SQLException{
        String sql = "DELETE FROM generos WHERE id = ?";
        
        try(Connection conexao = Conexao.abrir()){
            PreparedStatement executor = conexao.prepareStatement(sql);
            executor.setInt(1, id);
            
            executor.executeUpdate();
        }
    }
    
    public void editar(Genero genero) throws SQLException {
        String sql = "UPDATE generos SET nome = ? WHERE id = ?";
        
        try(Connection conexao = Conexao.abrir()){
            PreparedStatement executor = conexao.prepareStatement(sql);
            executor.setString(1, genero.getNome());
            executor.setInt(2, genero.getId());
            executor.executeUpdate();
        }
    }
}
    






