package br.com.proway.protify;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ExemploArrayList {

    public void exemploArrayListSimple() {
        ArrayList<String> alunos = new ArrayList();
        alunos.add("Lorenzo");
        alunos.add("Mateus");
        alunos.add("Lucia");
        alunos.add("Mario");
        alunos.add("Pablo");

        // Alterar um registro no ArrayList
        alunos.set(1, "Matheus");

        // Remover um aluno da lista de alunos
        alunos.remove(3); // Remover "Mario" da lista

        // Descobrir a quantidade de elementos do ArrayList
        int quantidadeAlunos = alunos.size();

        // Obter o nome do primeiro aluno
        String nomePrimeiroAluno = alunos.get(0);

        JOptionPane.showMessageDialog(null, "Quantidade de alunos" + quantidadeAlunos);

        JOptionPane.showMessageDialog(null,
                "Alunos: \n"
                + nomePrimeiroAluno + "\n"
                + alunos.get(1) + "\n"
                + alunos.get(2) + "\n"
                + alunos.get(3) + "\n"
        );
    }

    public void exemploArrayListObjeto() {
        Jogo gta6 = new Jogo();
        gta6.setNome("Grand Theft Auto");
        gta6.setPrecoUnitario(500);
        gta6.setQuantidade(1);

        ArrayList<Jogo> games = new ArrayList();
        games.add(gta6);

        Jogo fortnite = new Jogo();
        fortnite.setNome("Fortnyte");
        fortnite.setPrecoUnitario(0);
        fortnite.setQuantidade(1);
        games.add(fortnite);

        // Alterar o nome do jogo que está na primeira posição
        games.get(1).setNome("Fornite");

        // Apresentar todos os jogos
        for (int i = 0; i < games.size(); i++) {
            Jogo jogo = games.get(i);
            JOptionPane.showMessageDialog(null,
                    "Jogo: " + jogo.getNome()
                    + "\nQuantidade: " + jogo.getQuantidade()
                    + "\nPreço unitário: " + jogo.getPrecoUnitario());
        }

    }

    public static void main(String[] args) {
        new ExemploArrayList().exemploArrayListObjeto();
    }
    
    /*
    Ex1: Criar uma função exercicio01 com um ArrayList para armazenar o poder 
    dos pokemons
    Adicionar 65.6
    Adicionar 150.34
    Adicionar 200
    Adicionar 10
    
    Remover o segundo elemento
    Alterar o segundo elemento para 210
    Apresentar o tamanho da lista e os poderes
    
    Ex2.: Criar uma classe Pokemon com os atributos nome e numero
    Criar uma função exercicio02 com um ArrayList para armazenar os Pokemons
    Criar um pokemon Charizard 0007, adicionar na lista
    Criar um pokemon Squirtle 0007, adicionar na lista
    Criar um pokemon Psyduck 0054, adicionar na lista
    Alterar o numero do primeiro elemento para 0006
    
    Remover pokemon Psyduck
    Apresentar os pokemons
    */

    private class Jogo {

        private String nome;
        private double precoUnitario;
        private int quantidade;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getPrecoUnitario() {
            return precoUnitario;
        }

        public void setPrecoUnitario(double precoUnitario) {
            this.precoUnitario = precoUnitario;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

    }
}
// CREATE .add
// READ   .get
// UPDATE .set
// DELETE .remove
