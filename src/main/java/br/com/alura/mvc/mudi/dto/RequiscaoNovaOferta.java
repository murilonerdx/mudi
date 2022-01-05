package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.entities.Oferta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequiscaoNovaOferta {
    private Long id;
    private BigDecimal valor;
    private String dataDaEntrega;
    private String comentario;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    public RequiscaoNovaOferta(Long id, BigDecimal valor, String dataDaEntrega, String comentario) {
        this.id = id;
        this.valor = valor;
        this.dataDaEntrega = dataDaEntrega;
        this.comentario = comentario;
    }

    public RequiscaoNovaOferta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(String dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Oferta toOferta(){
        Oferta oferta = new Oferta();

        oferta.setComentario(this.comentario);
        oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, formatter));
        oferta.setValor(new BigDecimal(String.valueOf(this.valor)));
        return oferta;
    }
}
