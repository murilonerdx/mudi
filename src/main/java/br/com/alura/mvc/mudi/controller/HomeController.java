package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.entities.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/home")
    public String home(Model model) {
//        Pedido pedido = new Pedido();
//        pedido.setNomeProduto("Xiaomi Redmi Note 8");
//        pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/81UgYuadkpL._AC_SL1500_.jpg");
//        pedido.setUrlProduto("https://www.amazon.com.br/Smartphone-Xiaomi-Redmi-Note-64GB/dp/B07Y8YWTFL/ref=sr_1_6?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Xiaomi+Redmi+Note+8&qid=1600346040&sr=8-6");
//        pedido.setDescricao("uma descrição qualquer para esse pedido");

        Query select_p_from_pedido_p = entityManager.createQuery("select p from Pedido p", Pedido.class);
        List<Pedido> resultList = select_p_from_pedido_p.getResultList();

//        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", resultList);

        return "home";
    }
}
