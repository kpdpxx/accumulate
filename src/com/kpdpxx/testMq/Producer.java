package com.kpdpxx.testMq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

public class Producer {
	   public static void main(String[] args) throws MQClientException, InterruptedException {
		   /**
		            * һ��Ӧ�ô���һ��Producer����Ӧ����ά���˶��󣬿�������Ϊȫ�ֶ�����ߵ���<br>
		            * ע�⣺ProducerGroupName��Ҫ��Ӧ������֤Ψһ<br>
		            * ProducerGroup����������ͨ����Ϣʱ�����ò��󣬵��Ƿ��ͷֲ�ʽ������Ϣʱ���ȽϹؼ���
		            * ��Ϊ��������ز����Group�µ�����һ��Producer
		            */
		           DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

		   /**
		            * Producer������ʹ��֮ǰ����Ҫ����start��ʼ������ʼ��һ�μ���<br>
		            * ע�⣺�мǲ�������ÿ�η�����Ϣʱ��������start����
		            */
		           producer.setNamesrvAddr("127.0.0.1:9876");
		           producer.start();
		           /**
		            * Caused by: com.alibaba.rocketmq.remoting.exception.RemotingConnectException: connect to <10.73.129.22:10909> failed
		            * 1. Ŀǰ����д��RocketĬ�Ͽ�����VIPͨ����VIPͨ���˿�Ϊ10911-2=10909����Rocket������δ�����˿�10909����connect to <> failed��
		            *2. �����ʽ������һ�д���producer.setVipChannelEnabled(false);
		            */
		           producer.setVipChannelEnabled(false);

		   /**
		            * ������δ������һ��Producer������Է��Ͷ��topic�����tag����Ϣ��
		            * ע�⣺send������ͬ�����ã�ֻҪ�����쳣�ͱ�ʶ�ɹ������Ƿ��ͳɹ�Ҳ�ɻ��ж���״̬��<br>
		            * ������Ϣд��Master�ɹ�������Slave���ɹ������������Ϣ���ڳɹ������Ƕ��ڸ���Ӧ���������Ϣ�ɿ���Ҫ�󼫸ߣ�<br>
		            * ��Ҫ������������������⣬��Ϣ���ܻ���ڷ���ʧ�ܵ������ʧ��������Ӧ��������
		            */
		           try {
		               {
		                   Message msg = new Message("TopicTest1",// topic
		                           "TagA",// tag
		                           "OrderID001",// key
		                           ("Hello MetaQ").getBytes());// body
		                   SendResult sendResult = producer.send(msg);
		                   System.out.println(sendResult);
		               }

		               {
		                   Message msg = new Message("TopicTest2",// topic
		                           "TagB",// tag
		                           "OrderID0034",// key
		                           ("Hello MetaQ").getBytes());// body
		                   SendResult sendResult = producer.send(msg);
		                   System.out.println(sendResult);
		               }

		               {
		                   Message msg = new Message("TopicTest3",// topic
		                           "TagC",// tag
		                           "OrderID061",// key
		                           ("Hello MetaQ").getBytes());// body
		                   SendResult sendResult = producer.send(msg);
		                   System.out.println(sendResult);
		               }
		           } catch (Exception e) {
		               e.printStackTrace();
		           }

		   /**
		            * Ӧ���˳�ʱ��Ҫ����shutdown��������Դ���ر��������ӣ���MetaQ��������ע���Լ�
		            * ע�⣺���ǽ���Ӧ����JBOSS��Tomcat���������˳����������shutdown����
		            */
		           producer.shutdown();
		       }
}
