package us.rs.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.rs.order.beans.Packages;
@Repository
public interface PackagesDao extends JpaRepository<Packages,String> {
}
