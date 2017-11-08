package org.apache.activemq.artemis.example.tomcat.sample;

import javax.jms.Message;
import javax.jms.MessageListener;


public class SystemOutPrintLnMessageListener implements MessageListener {
   @Override
   public void onMessage(Message message) {
      System.out.println(message);
   }
}
