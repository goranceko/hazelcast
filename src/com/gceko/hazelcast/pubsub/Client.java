package com.gceko.hazelcast.pubsub;

import com.hazelcast.core.*;

public class Client implements MessageListener<StockPrice> {

    public Client(String topicName) {
        HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
        ITopic<StockPrice> topic = hzInstance.getTopic(topicName);
        topic.addMessageListener(this);
    }

    public static void main(String[] args) {
        new Client(MarketMaker.TOPIC_NAME);
    }

    /**
     * @see com.hazelcast.core.MessageListener#onMessage(com.hazelcast.core.Message)
     */
    @Override
    public void onMessage(Message<StockPrice> message) {
        System.out.println("Received: " + message.getMessageObject().toString());
    }

}
