//package us.rs.order.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import us.rs.order.beans.Order;
//import us.rs.order.beans.Packages;
//import us.rs.order.persistence.OrderDao;
//import us.rs.order.persistence.PackagesDao;
//
//import java.util.Optional;
//
//@Service
//public class PackageService {
//    @Autowired
//    PackagesDao packagesDao;
//    @Transactional
//    public Optional<Packages> getOrderById(String frId){
//        return packagesDao.findById(frId);
//
//    }
//
//    @Transactional
//    public void deletePackageById(String frId){
//        packagesDao.deleteById(frId);
//    }
//
//    @Transactional
//    public Packages updateOrderById(Packages packages,String frId){
//       return packagesDao.save(packages);
//    }
//
//    @Transactional
//    public Packages createOrderById(Packages packages,String frId){
//        return packagesDao.save(packages);
//    }
//}
