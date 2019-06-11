
public interface Publisher {
    //Publishes new message to Broker
    void publish(Message message, Broker broker);
}