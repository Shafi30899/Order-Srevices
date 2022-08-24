package us.rs.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import us.rs.order.aop.LoggerExecutionTime;


//@SpringBootApplication
@SpringBootApplication(scanBasePackages="us.rs.order")
@EnableJpaRepositories(basePackages = "us.rs.order.persistence")
@EntityScan(basePackages = "us.rs.order.beans")
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);


//		@LoggerExecutionTime
//		public void serve() throws InterruptedException{
//			Thread.sleep(2000);
//		}
	}

//	@LoggerExecutionTime
//	public void serve() throws InterruptedException{
//		Thread.sleep(2000);
//	}

}
