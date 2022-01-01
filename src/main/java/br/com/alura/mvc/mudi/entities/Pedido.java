package br.com.alura.mvc.mudi.entities;

import br.com.alura.mvc.mudi.dto.PedidoDTO;

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
    private BigDecimal valorNegociado;
    private LocalDate dataDaEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public Pedido(Long id, String nomeProduto, BigDecimal valorNegociado, LocalDate dataDaEntrega, String urlProduto, String urlImagem, String descricao) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.valorNegociado = valorNegociado;
        this.dataDaEntrega = dataDaEntrega;
        this.urlProduto = urlProduto;
        this.urlImagem = urlImagem;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getValorNegociado() {
        return valorNegociado;
    }

    public void setValorNegociado(BigDecimal valorNegociado) {
        this.valorNegociado = valorNegociado;
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

    public Pedido() {

    }

    public Pedido toPedido(PedidoDTO pedidoDTO) {
        this.id = pedidoDTO.getId();
        this.nomeProduto = pedidoDTO.getNomeProduto();
        this.valorNegociado = pedidoDTO.getValorNegociado();
        this.dataDaEntrega = pedidoDTO.getDataDaEntrega();
        this.urlProduto = pedidoDTO.getUrlProduto();
        this.urlImagem = pedidoDTO.getUrlImagem();
        this.descricao = pedidoDTO.getDescricao();
        return this;
    }

}
