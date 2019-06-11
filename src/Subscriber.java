import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {
    //store all messages received by the subscriber
    private List<Message> subscriberMessages = new ArrayList<Message>();

    public List<Message> getSubscriberMessages() {
        return subscriberMessages;
    }
    public void setSubscriberMessages(List<Message> subscriberMessages) {
        this.subscriberMessages = subscriberMessages;
    }

    //Add subscriber with Broker for a content
    public abstract void addSubscriber(String content, Broker broker);

    //Unsubscribe subscriber with Broker for a content
    public abstract void unSubscribe(String content, Broker broker);

    //Request specifically for messages related to content from Broker
    public abstract void getMessagesForSubscriberOfTopic(String content, Broker broker);

    //Print all messages received by the subscriber
    public void printMessages(){
        for(Message message : subscriberMessages){
            System.out.println("Message Topic -> "+ message.getTopic() + " : " + message.getPayload());
        }
    }
}