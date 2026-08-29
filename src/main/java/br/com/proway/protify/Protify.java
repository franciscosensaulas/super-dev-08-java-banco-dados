package br.com.proway.protify;

import br.com.proway.protify.dao.GeneroDAO;
import br.com.proway.protify.modelo.Genero;

public class Protify {

    public static void main(String[] args) {
        try {
//            Genero genero = new Genero();
//            genero.setNome("Pagode");
//            
//            GeneroDAO dao = new GeneroDAO();
//            dao.inserir(genero);
//            System.out.println("Genero cadastrado com sucesso");

//            Genero generoEditar = new Genero();
//            generoEditar.setId(4);
//            generoEditar.setNome("Pagodão");
            GeneroDAO dao = new GeneroDAO();
//            dao.editar(generoEditar);
//            System.out.println("Genero editado com sucesso");

            dao.consultarTodos();

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o genero");
            e.printStackTrace();
        }
    }
}
