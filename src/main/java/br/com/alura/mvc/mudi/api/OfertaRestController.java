package br.com.alura.mvc.mudi.api;


import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.entities.Oferta;
import br.com.alura.mvc.mudi.entities.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaRestController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
        if(!pedidoBuscado.isPresent()) {
            return null;
        }

        Pedido pedido = pedidoBuscado.get();

        Oferta novaOferta = requisicao.toOferta();
        novaOferta.setPedido(pedido);
        pedido.getOfertas().add(novaOferta);
        pedidoRepository.save(pedido);

        return novaOferta;
    }
}