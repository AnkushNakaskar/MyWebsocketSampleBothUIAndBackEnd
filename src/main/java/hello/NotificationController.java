package hello;

import java.io.IOException;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private SimpMessagingTemplate template;

	// @RequestMapping("/emailNotification")
	// @MessageMapping("/email_notification")
	// @SendTo("/notification/email")
	// public Greeting notification(HelloMessage message) throws IOException {
	// System.out.println("Ankush..You are the best..!!!");
	// return new Greeting("Hello, " + message.getName() + "!");
	// }

	@MessageMapping("/user/{userName}")
	public void simple(@DestinationVariable String userName) {
		System.out.println("Ankush....");
		template.convertAndSend("/notificationTopic/user/" + userName, new Greeting(userName,"Ankush"));
	}
}
