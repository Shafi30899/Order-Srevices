package us.rs.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.rs.order.beans.Order;
@Repository
public interface OrderDao extends JpaRepository<Order,Long> {
}
