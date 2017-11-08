package org.apache.activemq.artemis.example.tomcat.sample;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    
    @RequestMapping("/send")
    public @ResponseBody String send(@RequestParam(value="text", defaultValue="hello world") final String text) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });
        return "sent: " + text;
    }
}