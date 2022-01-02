package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.entities.Pedido;
import br.com.alura.mvc.mudi.entities.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);

//    @PersistenceContext
//    private EntityManager entityManager;

//    public List<Pedido> obterPedido(){
//        Query select_p_from_pedido_p = entityManager.createQuery("select p from Pedido p", Pedido.class);
//        return select_p_from_pedido_p.getResultList();
//    }

}
