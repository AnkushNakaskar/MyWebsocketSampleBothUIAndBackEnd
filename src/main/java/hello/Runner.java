package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import hello.backend.websocket.WebSocketNotificationFacade;


@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private WebSocketNotificationFacade notificationfacade;
	


	@Autowired
	private ConfigurableApplicationContext context;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message...");

		Thread.sleep(3000);
		for (int i = 0; i < 1000; i++) {
			System.out.println("Sending message...");
			
			notificationfacade.publishNotification();
		}
	}

}