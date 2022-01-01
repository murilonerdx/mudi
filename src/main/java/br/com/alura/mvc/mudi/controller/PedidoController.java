package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.PedidoDTO;
import br.com.alura.mvc.mudi.entities.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formulario(){
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novo(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        pedido.toPedido(pedidoDTO);

        pedidoRepository.save(pedido);

        return "pedido/formulario";
    }
}