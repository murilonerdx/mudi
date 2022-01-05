package br.com.alura.mvc.mudi.api;


import br.com.alura.mvc.mudi.dto.RequiscaoNovaOferta;
import br.com.alura.mvc.mudi.entities.Oferta;
import br.com.alura.mvc.mudi.entities.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaRestController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(RequiscaoNovaOferta oferta){
        Optional<Pedido> pedido = pedidoRepository.findById(oferta.getId());
        if(!pedido.isPresent())
            return null;

        Oferta novaOferta = oferta.toOferta();
        novaOferta.setPedido(pedido.get());
        pedido.get().getOfertas().add(novaOferta);

        pedidoRepository.save(pedido.get());

        return novaOferta;
    }
}
