package us.rs.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.rs.order.beans.OrderLine;
@Repository
public interface OrderLineDao extends JpaRepository<OrderLine,Long> {
}
