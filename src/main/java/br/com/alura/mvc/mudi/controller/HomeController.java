package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.entities.Pedido;
import br.com.alura.mvc.mudi.entities.enums.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping()
    public String home(Model model, Principal principal) {
//        Pedido pedido = new Pedido();
//        pedido.setNomeProduto("Xiaomi Redmi Note 8");
//        pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/81UgYuadkpL._AC_SL1500_.jpg");
//        pedido.setUrlProduto("https://www.amazon.com.br/Smartphone-Xiaomi-Redmi-Note-64GB/dp/B07Y8YWTFL/ref=sr_1_6?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Xiaomi+Redmi+Note+8&qid=1600346040&sr=8-6");
//        pedido.setDescricao("uma descrição qualquer para esse pedido");
//        List<Pedido> pedidos = Arrays.asList(pedido);

        List<Pedido> pedidos = repository.findAllByUsuario(principal.getName());


        model.addAttribute("pedidos", pedidos);
        return "home";
    }

    @GetMapping("/{status}")
    public String porStatus(@PathVariable("status") String status, Model model) {
        try{
            List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
            model.addAttribute("pedidos", pedidos);
            model.addAttribute("status", status);

            return "home";
        }catch(IllegalArgumentException e){
            return "redirect:/home";
        }
    }
}
