package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/email")
public class EmailController {
  @Autowired private JmsTemplate jmsTemplate;
  @PostMapping("/send")
  public void send(@RequestBody Email email) {
    System.out.println("Sending an email.");
    // Post message to the message queue named "OrderTransactionQueue"
    jmsTemplate.convertAndSend("EmailQueue", email);
  }
}