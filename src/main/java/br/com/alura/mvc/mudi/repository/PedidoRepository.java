package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.entities.Pedido;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PedidoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Pedido> obterPedido(){
        Query select_p_from_pedido_p = entityManager.createQuery("select p from Pedido p", Pedido.class);
        return select_p_from_pedido_p.getResultList();
    }

}
