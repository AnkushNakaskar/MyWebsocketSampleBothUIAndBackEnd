package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/notificationTopic");
        config.setApplicationDestinationPrefixes("/notificationApp");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/notificationEndPoint").setAllowedOrigins("*").withSockJS();
    }
    
	@Bean
	public WebSocketClient webSocketClient() {
		WebSocketClient webSocketClient = new StandardWebSocketClient();
		return webSocketClient;
	}


}