package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public Biblioteca(String nome, List<Livro> livros) {
        this.nome = nome;
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void adicionarLivro(Livro livro) {
        if (livro == null || livro.getTitulo() == null || livro.getTitulo().isBlank() ||
                livro.getAutor() == null || livro.getAutor().isBlank() ||
                livro.getDataPublicacao() == null) {
            throw new ArgumentoInvalidoException("Os dados do livro são inválidos.");
        }
        livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new ArgumentoInvalidoException("O título não pode ser nulo ou vazio.");
        }

        Livro livro = buscarLivroPorTitulo(titulo);
        livros.remove(livro);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new ArgumentoInvalidoException("O título não pode ser nulo ou vazio.");
        }

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        throw new LivroNaoEncontradoException("Livro não encontrado.");
    }

    public int contarLivros() {
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        if (ano == null) {
            throw new ArgumentoInvalidoException("O ano não pode ser nulo.");
        }

        List<Livro> livrosAteAno = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDataPublicacao().getYear() <= ano) {
                livrosAteAno.add(livro);
            }
        }
        return livrosAteAno;
    }

    public List<Livro> retornarTopCincoLivros() {
        List<Livro> topCincoLivros = new ArrayList<>();
        List<Livro> copiaLivros = new ArrayList<>(livros);

        for (int i = 0; i < 5 && !copiaLivros.isEmpty(); i++) {
            Livro melhorLivro = null;
            for (Livro livro : copiaLivros) {
                if (melhorLivro == null || livro.calcularMediaAvaliacoes() > melhorLivro.calcularMediaAvaliacoes()) {
                    melhorLivro = livro;
                }
            }
            if (melhorLivro != null) {
                topCincoLivros.add(melhorLivro);
                copiaLivros.remove(melhorLivro);
            }
        }
        return topCincoLivros;
    }

    @Override
    public String toString() {
        return "Biblioteca: " + nome;
    }
}
