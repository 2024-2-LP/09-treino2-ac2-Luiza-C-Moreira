package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;

    public Livro(){
        this.avaliacoes = new ArrayList<>();
    }

    public Livro(String titulo, String autor, LocalDate dataPublicacao) {
        if (titulo == null || titulo.isBlank() || autor == null || autor.isBlank() || dataPublicacao == null) {
            throw new ArgumentoInvalidoException("Dados do livro são inválidos");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
        if (descricao == null || descricao.isBlank() || qtdEstrelas == null || qtdEstrelas < 0 || qtdEstrelas > 5) {
            throw new ArgumentoInvalidoException("Descrição inválida ou quantidade de estrelas fora do intervalo (0-5)");
        }
        avaliacoes.add(new Avaliacao(descricao, qtdEstrelas));
    }

    public Double calcularMediaAvaliacoes(){
        if (avaliacoes.isEmpty()) {
            return 0.0;
        } else {
            Double somaMedia = 0.0;
            for (Avaliacao avaliacao: avaliacoes){
                somaMedia += avaliacao.getQtdEstrelas();
            }
            return somaMedia / avaliacoes.size();
        }
    }

    @Override
    public String toString() {
        return String.format("Livro: %s, Autor: %s, Data de Publicação: %s", titulo, autor, dataPublicacao);
    }
}