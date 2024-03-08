package com.gabo32.demos.DemoMqs;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import com.ibm.mq.jakarta.jms.MQDestination;
import com.ibm.mq.jakarta.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.jakarta.wmq.WMQConstants;

import jakarta.annotation.PostConstruct;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageConsumer;
import jakarta.jms.MessageListener;
import jakarta.jms.MessageProducer;
import jakarta.jms.Queue;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

@Service
public class Producer {

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

	@PostConstruct
	public void init() {
		producer1();
	}

	public void producer1() {
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

//			JmsTemplate jmsTemplate = new JmsTemplate(factory);
//			jmsTemplate.setExplicitQosEnabled(true);
//			jmsTemplate.setDefaultDestinationName(queueName);

//			for (int i = 0; i < 10000; i++) {
//				System.out.println("filll");
//				jmsTemplate.convertAndSend("hola mundo");
//			}

			Connection connection = factory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue(queueName);

			MessageProducer producer = session.createProducer(queue);
			connection.start();

			for (int i = 0; i < 100_0000; i++) {
				TextMessage textMessage = session.createTextMessage();
				System.out.println("filll1");
				textMessage.setText("hola mundo");
				try {
					producer.send(textMessage);
				} catch (JMSException e) {
					System.out.println("mq llena");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			producer.close();
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
