import org.hornetq.jms.client.HornetQDestination;
import org.hornetq.rest.Jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class ReceiveShipping
{
   public static void main(String[] args) throws Exception
   {
      System.out.println("Receive Setup...");
      ConnectionFactory factory = JmsHelper.createConnectionFactory("hornetq-client.xml");
      Destination destination = (HornetQDestination) HornetQDestination.fromAddress("jms.queue.shipping");

      Connection conn = factory.createConnection();
      try
      {
         Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
         MessageConsumer consumer = session.createConsumer(destination);
         consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message)
            {
               System.out.println("Received Message: " );
               Order order = null;
               if (Jms.isHttpMessage(message))
               {
//                  String o = Jms.getEntity(message, String.class);
//                  System.out.println(o);
                  order = Jms.getEntity(message, Order.class);
               }
               else
               {
                  try
                  {
                     order = (Order)((ObjectMessage)message).getObject();
                  }
                  catch (JMSException e)
                  {
                     throw new RuntimeException(e);
                  }
               }
               System.out.println(order);
            }
         }
         );
         conn.start();
         Thread.sleep(1000000);
      }
      finally
      {
         conn.close();
      }
   }
}