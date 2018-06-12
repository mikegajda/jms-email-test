package hello;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.*;

@Component
public class Receiver {

	@Autowired
  	private EmailRepository emailRepository;

  	@Autowired
  	private EmailController emailController;

    @JmsListener(destination = "EmailQueue", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
        emailRepository.save(email);
        //emailController.send(email);
    }

}