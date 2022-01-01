package br.com.alura.mvc.mudi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private BigDecimal valorNegociacao;
    private LocalDate dataDaEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public Pedido(String nomeProduto, BigDecimal valorNegociacao, LocalDate dataDaEntrega, String urlProduto, String urlImagem, String descricao) {
        this.nomeProduto = nomeProduto;
        this.valorNegociacao = valorNegociacao;
        this.dataDaEntrega = dataDaEntrega;
        this.urlProduto = urlProduto;
        this.urlImagem = urlImagem;
        this.descricao = descricao;
    }

    public Pedido() {

    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getValorNegociacao() {
        return valorNegociacao;
    }

    public void setValorNegociacao(BigDecimal valorNegociacao) {
        this.valorNegociacao = valorNegociacao;
    }

    public LocalDate getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(LocalDate dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
