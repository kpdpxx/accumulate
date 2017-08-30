package com.kpdpxx.testMq;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

public class Consumer {
	 /**
     * ��ǰ������PushConsumer�÷���ʹ�÷�ʽ���û��о�����Ϣ��RocketMQ�������Ƶ���Ӧ�ÿͻ��ˡ�<br>
     * ����ʵ��PushConsumer�ڲ���ʹ�ó���ѯPull��ʽ��Broker����Ϣ��Ȼ���ٻص��û�Listener����<br>
     */
    public static void main(String[] args) throws InterruptedException,
            MQClientException {
    	try{
    		/**
    		 * TopicTest
    		 */
        /**
         * һ��Ӧ�ô���һ��Consumer����Ӧ����ά���˶��󣬿�������Ϊȫ�ֶ�����ߵ���<br>
         * ע�⣺ConsumerGroupName��Ҫ��Ӧ������֤Ψһ
         */
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(
                "ConsumerGroupName");

        consumer.setNamesrvAddr("127.0.0.1:9876");
        /**
         * ����ָ��topic��tags�ֱ����TagA��TagC��TagD
         */
        consumer.subscribe("TopicTest1", "TagA || TagC || TagD");
        /**
         * ����ָ��topic��������Ϣ<br>
         * ע�⣺һ��consumer������Զ��Ķ��topic
         */
        consumer.subscribe("TopicTest2", "*");

        /**
         * ����Consumer��һ�������ǴӶ���ͷ����ʼ���ѻ��Ƕ���β����ʼ����<br>
         * ����ǵ�һ����������ô�����ϴ����ѵ�λ�ü�������
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.registerMessageListener(new MessageListenerConcurrently() {

            /**
             * * Ĭ��msgs��ֻ��һ����Ϣ������ͨ������consumeMessageBatchMaxSize����������������Ϣ
             */
            public ConsumeConcurrentlyStatus consumeMessage(
                    List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println(Thread.currentThread().getName()
                        + " Receive New Messages: " + msgs);

                MessageExt msg = msgs.get(0);
                System.out.println(new String(msg.getBody()));
                if (msg.getTopic().equals("TopicTest1")) {
                    // ִ��TopicTest1�������߼�
                    if (msg.getTags() != null && msg.getTags().equals("TagA")) {
                        // ִ��TagA������
                    	System.out.println("�յ�����TagA  �յ�����TagA�յ�����TagA");

                    } else if (msg.getTags() != null
                            && msg.getTags().equals("TagC")) {
                    	System.out.println("�յ�����TagC");
                        // ִ��TagC������
                    } else if (msg.getTags() != null
                            && msg.getTags().equals("TagD")) {
                    	System.out.println("�յ�����TagDDDDDDDDDD");

                        // ִ��TagD������
                    }
                } else if (msg.getTopic().equals("TopicTest2")) {
                	System.out.println("�յ�����TopicTest2  TopicTest2___TopicTest2");

                    // ִ��TopicTest2�������߼�
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        /**
         * Consumer������ʹ��֮ǰ����Ҫ����start��ʼ������ʼ��һ�μ���<br>
         */
        consumer.start();

        System.out.println("Consumer Started.");
    	}catch(Exception e ){
        	e.printStackTrace();
        }
    }
    
}
