package hello.backend.websocket;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSession.Receiptable;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import hello.HelloMessage;


public class NotificationStompSessionPublisher extends StompSessionHandlerAdapter {



	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
		HelloMessage message = new HelloMessage();
		message.setName("Ankus Nakaskar");
		try {
			Thread.sleep(1000);
			Receiptable rec = session.send("/notificationApp/user/"+"ankush".trim(), message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}