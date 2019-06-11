
public class PublisherImpl implements Publisher {
    //Publishes new message to Broker
    public void publish(Message message, Broker broker) {
        broker.addMessageToQueue(message);
    }
}