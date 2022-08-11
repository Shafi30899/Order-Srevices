package us.rs.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.rs.order.aop.LoggerExecutionTime;


@SpringBootApplication
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
