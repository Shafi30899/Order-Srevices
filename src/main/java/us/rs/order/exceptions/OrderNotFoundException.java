package us.rs.order.exceptions;

public class OrderNotFoundException extends RuntimeException{
   public OrderNotFoundException(String message){
       super(message);
   }

}
