package com.gabo32.demos.DemoMqs;
//
//import javax.jms.Connection;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageConsumer;
//import javax.jms.MessageListener;
//import javax.jms.MessageProducer;
//import javax.jms.Queue;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//
//import org.springframework.stereotype.Service;
//
//import com.ibm.mq.jms.MQConnectionFactory;
//import com.ibm.mq.jms.MQDestination;
//import com.ibm.msg.client.wmq.WMQConstants;

import org.springframework.stereotype.Service;

@Service
public class ServiceMqListen {

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

//	@PostConstruct
//	public void produce() {
//		try {
//			MQConnectionFactory factory = new MQConnectionFactory();
//			factory.setTransportType(WMQConstants.WMQ_CM_BINDINGS_THEN_CLIENT);
//			factory.setHostName(host);
//			factory.setPort(port);
//			factory.setChannel(channel);
//
//			factory.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
//			factory.setStringProperty(WMQConstants.USERID, userId);
//			factory.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, false);
//
//			Connection connection = factory.createConnection();
//			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			Queue queue = session.createQueue(queueName);
//
//			MessageProducer producer = session.createProducer(queue);
//			connection.start();
//
//			for (int i = 0; i < 10000; i++) {
//			TextMessage textMessage = session.createTextMessage();
//			System.out.println("filll");
//			textMessage.setText("hola mundo");
//			producer.send(textMessage);
//			}
//
//			producer.close();
//			session.close();
//			connection.close();
//		} catch (
//
//		JMSException e) {
//			e.printStackTrace();
//		}
//	}

	public String getText() {
		return "{\"eventActions\":[{\"actionStatus\":\"SUCCESS\",\"executedTime\":\"2024-02-19T13:21:05.236\",\"actionData\":{\"fecha_oper\":\"30/01/2024\",\"deliveryMethod\":\"3\",\"hora\":\"14:10:32\",\"idEvent\":\"3390\",\"rqUID\":\"f19e98c1-01c9-48d8-a350-e7c70dc068d7\",\"term_cuenta\":\"7524\",\"monto\":\"$6,370.00\",\"alertIdTemplate\":\"304552\",\"tipo_tarjeta\":\"Cr&eacute;dito\",\"nom_comercio\":\"PAYPAL *UBERBV EATS 35314\",\"channelId\":\"1344\",\"clientIPAddress\":\"0.0.0.0\",\"emisor\":\"Santander Consumo\"},\"actionId\":\"sendNotification\",\"createdTime\":\"2024-02-19T13:21:04\"},{\"actionStatus\":\"PENDING\",\"executedTime\":null,\"actionData\":{\"motivo\":\" \",\"marcaTarjeta\":\"Visa\",\"tipoTarjeta\":\"FISICA\",\"deliveryMethod\":\"1\",\"cuentaDestino\":\"\",\"clacon\":\"\",\"tipoCompra\":\"Revolvente\",\"idEvent\":\"3485\",\"importeBonificacion\":\"6370\",\"contratoPampa\":\"00144857740014398710\",\"producto\":\"742107\",\"indicadorNaturaleza\":\"0\",\"buc\":\"33478611\",\"factura\":\"6390\",\"estatus\":1,\"alertIdTemplate\":\"304612\",\"cuentaOrigen\":\"149876543219875000\",\"observaciones\":\"\",\"modoEntrada\":\"048102000000\",\"pan\":\"4915735004967524\",\"codigoCampania\":\"BUENFIN\",\"channelId\":\"1106\",\"referencia\":\"623372638273819\",\"clientIPAddress\":\"0.0.0.0\"},\"actionId\":\"sendBonificaciones\",\"createdTime\":\"2024-02-19T13:21:04\"},{\"actionStatus\":\"SUCCESS\",\"executedTime\":\"2024-02-19T13:21:05.236\",\"actionData\":{\"deliveryMethod\":\"1\",\"MONTO\":\"$6,370.00\",\"idEvent\":\"6385\",\"COMERCIO\":\"6MCITICKETMASTER MEX\",\"rqUID\":\"4a279546-c754-478b-b05d-a6e1092e1fb0\",\"PLAZO\":\"6\",\"COMERCIO2\":\"PAYPAL *UBERBV EATS\",\"MONEDA\":\"484\",\"MESES\":\"SSSSSSSSSSSS\",\"alertIdTemplate\":\"306368\",\"TIPOCUOTA\":\"SMC1\",\"AFILIACION\":\" \",\"PAN\":\"4915735004967524\",\"TASA\":\"1.4%\",\"channelId\":\"1936\",\"OCULTA\":\"0\",\"clientIPAddress\":\"RTCore\",\"CARENCIA\":\"00\"},\"actionId\":\"sendNotification\",\"createdTime\":\"2024-02-19T13:21:04\"}],\"eventData\":{\"IMPORTE_CONC_01\":\"000000037000\",\"TJT_PAN_UN_02\":\"16\",\"TJT_PAN_UN_01\":\"16\",\"BLINDAJE\":\"0\",\"TOKENQ6\":\"\",\"COD_AUTORIZ_02\":\"003217\",\"FEC_CADUCID_01\":\"2401\",\"RED_ELM_CD_01\":\"00000000001\",\"SESION_ORIGEN_01\":\"00000000 \",\"IMPORTE_TRAN_01\":\"000000637000\",\"IMPORTE_TRAN_02\":\"000000637000\",\"NOMDIR_COMERCIO_01\":\"PAYPAL *UBERBV EATS 35314369001 \",\"TERMINAL_CD_01\":\"00000001\",\"BF21\":\"0\",\"NUM_IDENT_TRANS_02\":\"2403020246461017\",\"COD_COMERCIO_01\":\"000980020327998\",\"NUM_IDENT_TRANS_01\":\"2403020246461017\",\"Encabezado_02\":\"@112345@DCMPM0517 P\",\"Encabezado_01\":\"P2X9MP7EPRIFSCMX20240130202401301410321800\",\"PRIV_ORIGEN_01\":\" \",\"MODO_ENTRADA_01\":\"81\",\"FHOTRANS_01\":\"20240130141032\",\"SEGMENTO_01_01\":\"04\",\"CV_BONIFICACION\":\"0\",\"FHOTRANS_02\":\"20240130141032\",\"IMPORTE_TASAS_01\":\"000000000000\",\"SESION_SIA_02\":\"4030484\",\"ENTIDAD_ADQ_01\":\"00000419881\",\"SEGMENTO_05_01\":\"000000\",\"SESION_SIA_01\":\"4030484\",\"ACTIVIDAD_ENTRADA_01\":\"5812\",\"IDTM_01\":\"1100\",\"IDTM_02\":\"1110\",\"COD_MONEDA_ORI_01\":\"484\",\"TJT_PAN_NU_01\":\"4915735004967524\",\"TJT_PAN_NU_02\":\"4915735004967524\",\"COD_MONEDA_CON_01\":\"484\",\"INFORMACION_SALDOS_02\":[{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\" \",\"SIGNO_SALDO_02\":\" \",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000183757\",\"TIPO_SALDO_02\":\"0051\",\"SIGNO_SALDO_02\":\"+\",\"TIPO_MONEDA_02\":\"484\"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000019223\",\"TIPO_SALDO_02\":\"0061\",\"SIGNO_SALDO_02\":\"+\",\"TIPO_MONEDA_02\":\"999\"},{\"SALDO_IMPORTE_02\":\"000005216243\",\"TIPO_SALDO_02\":\"0059\",\"SIGNO_SALDO_02\":\"+\",\"TIPO_MONEDA_02\":\"484\"},{\"SALDO_IMPORTE_02\":\" \",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\" \"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000202457\",\"TIPO_SALDO_02\":\"0052\",\"SIGNO_SALDO_02\":\"+\",\"TIPO_MONEDA_02\":\"484\"},{\"SALDO_IMPORTE_02\":\" \",\"TIPO_SALDO_02\":\" \",\"SIGNO_SALDO_02\":\" \",\"TIPO_MONEDA_02\":\" \"}],\"DATOS_ADICIONALES_01\":\"0201032502027C9 9028C 08628E 000\",\"TIP_TRAN_CODPRC_02\":\"000100\",\"IMPORTE_ORIG_01\":\"000000037000\",\"TIP_TRAN_CODPRC_01\":\"000100\",\"REQUEST_CAMPAIGN_02\":\"D\",\"LONGITUD_SALDOS_02\":\"0267\",\"COD_MONEDA_01\":\"484\",\"IND_CONVERSION_DEC_01\":\"6\",\"PAIS_ADQ_CD_01\":\"484\",\"COD_RESPUESTA_02\":\"000\",\"FECHA_CONTABLE_02\":\"20240130\",\"COD_MONEDA_02\":\"484\",\"FECHA_CONTABLE_01\":\"00000000\",\"COD_MOND_TASA_01\":\"000\",\"ADICION_RESP_DATO_01\":\"211\",\"REFER_OPERAC_02\":\"403020541944\",\"COD_FORMATO_01\":\"01\",\"REFER_OPERAC_01\":\"403020541944\",\"ACTIVIDAD_CD_01\":\"5812\",\"BONIFICACION\":\"0\",\"SEGMENTO_03_01\":\"0\",\"CAPACIDAD_ENT_PIN_01\":\"2\",\"COD_FORMATO_02\":\"02\",\"IND_CONVERSION_01\":\"1000000\"},\"eventHeader\":{\"eventId\":\"c474cd69-50cd-4fdf-ae82-c35805_finan_lay\",\"keyValue\":\"4915735004967524\",\"keyName\":\"PAN\",\"refTrans\":\"MP7E\",\"timestamp\":\"2024-01-30T14:11:12\"},\"rqUID\":\"d7ed881c-3dac-4cee-a314-a9f6a6a7e4b9\",\"currentState\":{\"useCase\":\"TWOWAYS\",\"code\":\"FINANCING_OFFER_2\",\"auditEvent\":null,\"db_expireDate\":null,\"db_ttl\":259200,\"timestamp\":\"2024-02-19T13:21:04\"},\"contextData\":{\"campaigns\":{\"IDLC\":\"\",\"MCI\":{}},\"data_integration\":[{\"MST_CLIENTES_RT_CORE$NOMBRE\":\"DOROTEOS\",\"MST_TARJETAS_RT_CORE$COD_SUBPROD\":\"2107\",\"MST_TARJETAS_RT_CORE$COD_PRODUCTO\":\"74\",\"MST_TARJETAS_RT_CORE$LIM_CRED_TDC\":\"54000\",\"MST_CLIENTES_RT_CORE$AP_PATERNO\":\"ARANGOS\",\"MST_CONTRATOS_RT_CORE$NUM_CONTRATO\":\"740014398710\",\"MST_CLIENTES_RT_CORE$SEGMENTO_ALTAIR\":\"14\",\"MST_CONTRATOS_RT_CORE$COD_C_ALT\":\"4857\",\"MST_CLIENTES_RT_CORE$SMS\":\"1\",\"MST_CLIENTES_RT_CORE$BUC\":\"33478611\",\"MST_CLIENTES_RT_CORE$CONTACTO\":\"1\",\"MST_CLIENTES_RT_CORE$EMAIL\":\"1\",\"MST_TARJETAS_RT_CORE$TIPO_CTE\":\"TI\",\"MST_TARJETAS_RT_CORE$COD_PLASTICO\":\"4915735004967524\"}]}}\r\n"
				+ "2024-02-19 13:21:05.281  INFO 1 --- [pool-2-thread-2] m.s.m.e.e.s.EventEntityImplService       : Ingresa a metodo saveEvent: {\"eventActions\":[{\"actionStatus\":\"SUCCESS\",\"executedTime\":\"2024-02-19T13:21:05.236\",\"actionData\":{\"fecha_oper\":\"30/01/2024\",\"deliveryMethod\":\"3\",\"hora\":\"14:10:32\",\"idEvent\":\"3390\",\"rqUID\":\"f19e98c1-01c9-48d8-a350-e7c70dc068d7\",\"term_cuenta\":\"7524\",\"monto\":\"$6,370.00\",\"alertIdTemplate\":\"304552\",\"tipo_tarjeta\":\"Cr&eacute;dito\",\"nom_comercio\":\"PAYPAL *UBERBV EATS 35314\",\"channelId\":\"1344\",\"clientIPAddress\":\"0.0.0.0\",\"emisor\":\"Santander Consumo\"},\"actionId\":\"sendNotification\",\"createdTime\":\"2024-02-19T13:21:04\"},{\"actionStatus\":\"PENDING\",\"executedTime\":null,\"actionData\":{\"motivo\":\" \",\"marcaTarjeta\":\"Visa\",\"tipoTarjeta\":\"FISICA\",\"deliveryMethod\":\"1\",\"cuentaDestino\":\"\",\"clacon\":\"\",\"tipoCompra\":\"Revolvente\",\"idEvent\":\"3485\",\"importeBonificacion\":\"6370\",\"contratoPampa\":\"00144857740014398710\",\"producto\":\"742107\",\"indicadorNaturaleza\":\"0\",\"buc\":\"33478611\",\"factura\":\"6390\",\"estatus\":1,\"alertIdTemplate\":\"304612\",\"cuentaOrigen\":\"149876543219875000\",\"observaciones\":\"\",\"modoEntrada\":\"048102000000\",\"pan\":\"4915735004967524\",\"codigoCampania\":\"BUENFIN\",\"channelId\":\"1106\",\"referencia\":\"623372638273819\",\"clientIPAddress\":\"0.0.0.0\"},\"actionId\":\"sendBonificaciones\",\"createdTime\":\"2024-02-19T13:21:04\"},{\"actionStatus\":\"SUCCESS\",\"executedTime\":\"2024-02-19T13:21:05.236\",\"actionData\":{\"deliveryMethod\":\"1\",\"MONTO\":\"$6,370.00\",\"idEvent\":\"6385\",\"COMERCIO\":\"6MCITICKETMASTER MEX\",\"rqUID\":\"4a279546-c754-478b-b05d-a6e1092e1fb0\",\"PLAZO\":\"6\",\"COMERCIO2\":\"PAYPAL *UBERBV EATS\",\"MONEDA\":\"484\",\"MESES\":\"SSSSSSSSSSSS\",\"alertIdTemplate\":\"306368\",\"TIPOCUOTA\":\"SMC1\",\"AFILIACION\":\" \",\"PAN\":\"4915735004967524\",\"TASA\":\"1.4%\",\"channelId\":\"1936\",\"OCULTA\":\"0\",\"clientIPAddress\":\"RTCore\",\"CARENCIA\":\"00\"},\"actionId\":\"sendNotification\",\"createdTime\":\"2024-02-19T13:21:04\"}],\"eventData\":{\"IMPORTE_CONC_01\":\"000000037000\",\"TJT_PAN_UN_02\":\"16\",\"TJT_PAN_UN_01\":\"16\",\"BLINDAJE\":\"0\",\"TOKENQ6\":\"\",\"COD_AUTORIZ_02\":\"003217\",\"FEC_CADUCID_01\":\"2401\",\"RED_ELM_CD_01\":\"00000000001\",\"SESION_ORIGEN_01\":\"00000000 \",\"IMPORTE_TRAN_01\":\"000000637000\",\"IMPORTE_TRAN_02\":\"000000637000\",\"NOMDIR_COMERCIO_01\":\"PAYPAL *UBERBV EATS 35314369001 \",\"TERMINAL_CD_01\":\"00000001\",\"BF21\":\"0\",\"NUM_IDENT_TRANS_02\":\"2403020246461017\",\"COD_COMERCIO_01\":\"000980020327998\",\"NUM_IDENT_TRANS_01\":\"2403020246461017\",\"Encabezado_02\":\"@112345@DCMPM0517 P\",\"Encabezado_01\":\"P2X9MP7EPRIFSCMX20240130202401301410321800\",\"PRIV_ORIGEN_01\":\" \",\"MODO_ENTRADA_01\":\"81\",\"FHOTRANS_01\":\"20240130141032\",\"SEGMENTO_01_01\":\"04\",\"CV_BONIFICACION\":\"0\",\"FHOTRANS_02\":\"20240130141032\",\"IMPORTE_TASAS_01\":\"000000000000\",\"SESION_SIA_02\":\"4030484\",\"ENTIDAD_ADQ_01\":\"00000419881\",\"SEGMENTO_05_01\":\"000000\",\"SESION_SIA_01\":\"4030484\",\"ACTIVIDAD_ENTRADA_01\":\"5812\",\"IDTM_01\":\"1100\",\"IDTM_02\":\"1110\",\"COD_MONEDA_ORI_01\":\"484\",\"TJT_PAN_NU_01\":\"4915735004967524\",\"TJT_PAN_NU_02\":\"4915735004967524\",\"COD_MONEDA_CON_01\":\"484\",\"INFORMACION_SALDOS_02\":[{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\" \",\"SIGNO_SALDO_02\":\" \",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000183757\",\"TIPO_SALDO_02\":\"0051\",\"SIGNO_SALDO_02\":\"+\",\"TIPO_MONEDA_02\":\"484\"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000019223\",\"TIPO_SALDO_02\":\"0061\",\"SIGNO_SALDO_02\":\"+\",\"TIPO_MONEDA_02\":\"999\"},{\"SALDO_IMPORTE_02\":\"000005216243\",\"TIPO_SALDO_02\":\"0059\",\"SIGNO_SALDO_02\":\"+\",\"TIPO_MONEDA_02\":\"484\"},{\"SALDO_IMPORTE_02\":\" \",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\" \"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000000000\",\"TIPO_SALDO_02\":\"0000\",\"SIGNO_SALDO_02\":\"0\",\"TIPO_MONEDA_02\":\"000\"},{\"SALDO_IMPORTE_02\":\"000000202457\",\"TIPO_SALDO_02\":\"0052\",\"SIGNO_SALDO_02\":\"+\",\"TIPO_MONEDA_02\":\"484\"},{\"SALDO_IMPORTE_02\":\" \",\"TIPO_SALDO_02\":\" \",\"SIGNO_SALDO_02\":\" \",\"TIPO_MONEDA_02\":\" \"}],\"DATOS_ADICIONALES_01\":\"0201032502027C9 9028C 08628E 000\",\"TIP_TRAN_CODPRC_02\":\"000100\",\"IMPORTE_ORIG_01\":\"000000037000\",\"TIP_TRAN_CODPRC_01\":\"000100\",\"REQUEST_CAMPAIGN_02\":\"D\",\"LONGITUD_SALDOS_02\":\"0267\",\"COD_MONEDA_01\":\"484\",\"IND_CONVERSION_DEC_01\":\"6\",\"PAIS_ADQ_CD_01\":\"484\",\"COD_RESPUESTA_02\":\"000\",\"FECHA_CONTABLE_02\":\"20240130\",\"COD_MONEDA_02\":\"484\",\"FECHA_CONTABLE_01\":\"00000000\",\"COD_MOND_TASA_01\":\"000\",\"ADICION_RESP_DATO_01\":\"211\",\"REFER_OPERAC_02\":\"403020541944\",\"COD_FORMATO_01\":\"01\",\"REFER_OPERAC_01\":\"403020541944\",\"ACTIVIDAD_CD_01\":\"5812\",\"BONIFICACION\":\"0\",\"SEGMENTO_03_01\":\"0\",\"CAPACIDAD_ENT_PIN_01\":\"2\",\"COD_FORMATO_02\":\"02\",\"IND_CONVERSION_01\":\"1000000\"},\"eventHeader\":{\"eventId\":\"c474cd69-50cd-4fdf-ae82-c35805_finan_lay\",\"keyValue\":\"4915735004967524\",\"keyName\":\"PAN\",\"refTrans\":\"MP7E\",\"timestamp\":\"2024-01-30T14:11:12\"},\"rqUID\":\"d7ed881c-3dac-4cee-a314-a9f6a6a7e4b9\",\"currentState\":{\"useCase\":\"TWOWAYS\",\"code\":\"FINANCING_OFFER_2\",\"auditEvent\":null,\"db_expireDate\":null,\"db_ttl\":259200,\"timestamp\":\"2024-02-19T13:21:04\"},\"contextData\":{\"campaigns\":{\"IDLC\":\"\",\"MCI\":{}},\"data_integration\":[{\"MST_CLIENTES_RT_CORE$NOMBRE\":\"DOROTEOS\",\"MST_TARJETAS_RT_CORE$COD_SUBPROD\":\"2107\",\"MST_TARJETAS_RT_CORE$COD_PRODUCTO\":\"74\",\"MST_TARJETAS_RT_CORE$LIM_CRED_TDC\":\"54000\",\"MST_CLIENTES_RT_CORE$AP_PATERNO\":\"ARANGOS\",\"MST_CONTRATOS_RT_CORE$NUM_CONTRATO\":\"740014398710\",\"MST_CLIENTES_RT_CORE$SEGMENTO_ALTAIR\":\"14\",\"MST_CONTRATOS_RT_CORE$COD_C_ALT\":\"4857\",\"MST_CLIENTES_RT_CORE$SMS\":\"1\",\"MST_CLIENTES_RT_CORE$BUC\":\"33478611\",\"MST_CLIENTES_RT_CORE$CONTACTO\":\"1\",\"MST_CLIENTES_RT_CORE$EMAIL\":\"1\",\"MST_TARJETAS_RT_CORE$TIPO_CTE\":\"TI\",\"MST_TARJETAS_RT_CORE$COD_PLASTICO\":\"4915735004967524\"}]}}";
	}

//	@PostConstruct
//	public void listen() {
//		try {
//			MQConnectionFactory factory = new MQConnectionFactory();
//			factory.setTransportType(WMQConstants.WMQ_CM_BINDINGS_THEN_CLIENT);
//			factory.setHostName(host);
//			factory.setPort(port);
//			factory.setChannel(channel);
//
//			factory.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
//			factory.setStringProperty(WMQConstants.USERID, userId);
//			factory.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, false);
//
//			Connection connection = factory.createConnection();
//			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			Queue queue = session.createQueue(queueName);
//			MessageConsumer consumer = session.createConsumer(new MQDestination(queueName));
//
//			connection.start();
//
//			System.out.println("listen");
////			for (int i = 0; i < 1000; i++) {
//			consumer.setMessageListener(new MessageListener() {
//
//				@Override
//				public void onMessage(Message message) {
//					try {
//						String msg = message.getBody(String.class);
//
////						message.acknowledge();
//						System.out.println("Message -> " + msg);
//					} catch (JMSException e) {
//						e.printStackTrace();
//					}
//
//				}
//			});
////			}
//
////			consumer.close();
////			session.close();
////			connection.close();
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}
//	}
}
