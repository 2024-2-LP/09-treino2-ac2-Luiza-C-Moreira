package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

public class Avaliacao {
    private String descricao;
    private Double qtdEstrelas;

    public Avaliacao(){}

    public Avaliacao(String descricao, Double qtdEstrelas) {
        if (descricao == null || descricao.isBlank() || qtdEstrelas < 0 || qtdEstrelas > 5) {
            throw new ArgumentoInvalidoException("Descrição inválida ou quantidade de estrelas fora do intervalo (0-5)");
        }
        this.descricao = descricao;
        this.qtdEstrelas = qtdEstrelas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getQtdEstrelas() {
        return qtdEstrelas;
    }

    public void setQtdEstrelas(Double qtdEstrelas) {
        this.qtdEstrelas = qtdEstrelas;
    }

    @Override
    public String toString() {
        return String.format("Avaliação: %s, Estrelas: %.1f", descricao, qtdEstrelas);
    }
}
