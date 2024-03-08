package com.gabo32.demos.DemoMqs;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import com.ibm.msg.client.jakarta.wmq.WMQConstants;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@Service
public class Listener {

	int port = 4042;
	String host = "mwnmrdlo21mxr01.ilm.dev.mx.corp";
//	String host = "mwnmrilo21mxr01.ilm.pre.mx.corp";

	String channel = "SMNT.CLNT.D";
//	String channel = "SMNT.CLNT.G";

	String userId = "DEUPRTCO";
//	String userId = "gcuprtmq";

	String manager = "QXSMNTD";
//	String manager = "QXSMNTG";

//	String queueName = "OP.RULE.QL.D";
	String queueName = "OP.EVENT.QL.D";
	
	private static AtomicLong cont = new AtomicLong(0);
	
	DefaultMessageListenerContainer container;

	@PostConstruct
	public void init() {

		(new Thread(new Runnable() {
			public void run() {
				listen();
			}
		})).start();

	}

	public void listen() {
		try {
			MQConnectionFactory factory = new MQConnectionFactory();
//			MQQueueConnectionFactory factory = new MQQueueConnectionFactory();
			factory.setTransportType(WMQConstants.WMQ_CM_BINDINGS_THEN_CLIENT);
			factory.setHostName(host);
			factory.setPort(port);
			factory.setChannel(channel);

			factory.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
			factory.setStringProperty(WMQConstants.USERID, userId);
			factory.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, false);

			FixedBackOff backOff = new FixedBackOff();
			backOff.setMaxAttempts(3);
			backOff.setInterval(1000);
			
			long init = System.currentTimeMillis();

			container = new DefaultMessageListenerContainer();
			container.setConnectionFactory(factory);
			container.setDestinationName(queueName);
			container.setMaxConcurrentConsumers(20);
			container.setConcurrentConsumers(20);
			container.setBackOff(backOff);
			container.setSessionTransacted(true);
			container.setMessageListener(new MessageListener() {

				@Override
				public void onMessage(Message message) {
					long end = System.currentTimeMillis();
					try {
						System.out.println("LLego mensaje "+(cont.getAndIncrement()) + " - time "+ (end - init ) +"ms - "+ message.getBody(String.class).toString());
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			container.initialize();
			container.start();

			container.setErrorHandler(new ErrorHandler() {

				@Override
				public void handleError(Throwable t) {
					t.printStackTrace();

				}
			});
			System.out.println("create mq");
//			ConnectionFactory cf = container.getConnectionFactory();
//			Connection connection = cf.createConnection();
//			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			Queue queue = session.createQueue(queueName);

			System.out.println("listen");
			
			
			

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		container.stop();
		container.shutdown();
	}
}
