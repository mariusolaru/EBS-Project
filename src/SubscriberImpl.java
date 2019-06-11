
public class SubscriberImpl extends Subscriber {
    //Add subscriber with Broker for a content
    public void addSubscriber(String content, Broker broker) {
        broker.addSubscriber(content, this);
    }

    //Unsubscribe subscriber with Broker for a content
    public void unSubscribe(String content, Broker broker) {
        broker.removeSubscriber(content, this);
    }

    //Request specifically for messages related to content from Broker
    public void getMessagesForSubscriberOfTopic(String content, Broker broker) {
        broker.getMessagesForSubscriberOfTopic(content, this);

    }
}