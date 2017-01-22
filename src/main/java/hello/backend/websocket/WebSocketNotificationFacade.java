package hello.backend.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;


@Component
public class WebSocketNotificationFacade {

	@Autowired
	private WebSocketClient webSocketClient;



	public void publishNotification() {
		try {
			WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
			String webSocketCountUrl = "ws://localhost:8080/notificationEndPoint/websocket";
			stompClient.setMessageConverter(new MappingJackson2MessageConverter());
			NotificationStompSessionPublisher sessionHandler = new NotificationStompSessionPublisher();
			ListenableFuture<StompSession> tp = stompClient.connect(webSocketCountUrl, sessionHandler);
			System.out.println(tp);
			StompSession tp1 = tp.get();
			System.out.println(tp1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
