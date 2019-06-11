
public class DriverClass {

    public static void main(String[] args) {

        //Instantiate publishers, subscribers and Broker
        Publisher javaPublisher = new PublisherImpl();
        Publisher pythonPublisher = new PublisherImpl();

        Subscriber javaSubscriber = new SubscriberImpl();
        Subscriber allLanguagesSubscriber = new SubscriberImpl();
        Subscriber pythonSubscriber = new SubscriberImpl();

        Broker broker1 = new Broker();
        Broker broker2 = new Broker();


        // Declare Messages and Publish Messages to Broker
        Message javaMsg1 = new Message("Java", "Core Java Concepts");
        Message javaMsg2 = new Message("Java", "Spring MVC : Dependency Injection and AOP");
        Message javaMsg3 = new Message("Java", "JPA & Hibernate");

        javaPublisher.publish(javaMsg1, broker);
        javaPublisher.publish(javaMsg2, broker);
        javaPublisher.publish(javaMsg3, broker);

        Message pythonMsg1 = new Message("Python", "Easy and Powerful programming language");
        Message pythonMsg2 = new Message("Python", "Advanced Python message");

        pythonPublisher.publish(pythonMsg1, broker);
        pythonPublisher.publish(pythonMsg2, broker);

        //Declare Subscribers
        javaSubscriber.addSubscriber("Java", broker);		//Java subscriber only subscribes to Java topics
        pythonSubscriber.addSubscriber("Python", broker);   //Python subscriber only subscribes to Python topics
        allLanguagesSubscriber.addSubscriber("Java", broker);	//all subscriber, subscribes to both Java and Python
        allLanguagesSubscriber.addSubscriber("Python", broker);

        //Trying unSubscribing a subscriber
        //pythonSubscriber.unSubscribe("Python", broker);

        //Broadcast message to all subscribers. After broadcast, messageQueue will be empty in Broker
        broker.broadcast();

        //Print messages of each subscriber to see which messages they got
        System.out.println("Messages of Java Subscriber are: ");
        javaSubscriber.printMessages();

        System.out.println("\nMessages of Python Subscriber are: ");
        pythonSubscriber.printMessages();

        System.out.println("\nMessages of All Languages Subscriber are: ");
        allLanguagesSubscriber.printMessages();

        //After broadcast the messagesQueue will be empty, so publishing new messages to server
        System.out.println("\nPublishing 2 more Java Messages...");
        Message javaMsg4 = new Message("Java", "JSP and Servlets");
        Message javaMsg5 = new Message("Java", "Struts framework");

        javaPublisher.publish(javaMsg4, broker);
        javaPublisher.publish(javaMsg5, broker);

        javaSubscriber.getMessagesForSubscriberOfTopic("Java", broker);
        System.out.println("\nMessages of Java Subscriber now are: ");
        javaSubscriber.printMessages();
    }
}