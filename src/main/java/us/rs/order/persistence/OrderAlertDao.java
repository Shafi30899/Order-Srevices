package us.rs.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.rs.order.beans.OrderAlerts;
@Repository
public interface OrderAlertDao extends JpaRepository<OrderAlerts,Long> {
}
