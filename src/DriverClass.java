import java.util.Random;

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

        Random rand = new Random();
        int randomNum = rand.nextInt((2 - 0) + 1) + 0;

        Random rand2 = new Random();
        int randomNum2 = rand2.nextInt((1 - 0) + 1) + 0;

        // Declare Messages and Publish Messages to Broker
        for (int i = 0; i < 10000; ++i) {

            if (randomNum == 0) {
                Message javaMsg1 = new Message("Java", String.valueOf(i));

                if (randomNum2 == 0) {
                    javaPublisher.publish(javaMsg1, broker1);
                } else {
                    javaPublisher.publish(javaMsg1, broker2);
                }
            } else if (randomNum == 1) {
                Message pythonMsg1 = new Message("Python", String.valueOf(1));
                if (randomNum2 == 0) {
                    pythonPublisher.publish(pythonMsg1, broker1);
                } else {
                    pythonPublisher.publish(pythonMsg1, broker1);
                }
            }
        }

        // Declare Subscribers
        randomNum = rand.nextInt((1 - 0) + 1) + 0;

        if (randomNum == 1) {
            javaSubscriber.addSubscriber("Java", broker2);        //Java subscriber only subscribes to Java topics
        } else {
            javaSubscriber.addSubscriber("Java", broker2);        //Java subscriber only subscribes to Java topics
        }

        randomNum = rand.nextInt((1 - 0) + 1) + 0;
        if (randomNum == 1) {
            pythonSubscriber.addSubscriber("Python", broker1);   //Python subscriber only subscribes to Python topics
        } else {
            pythonSubscriber.addSubscriber("Python", broker2);   //Python subscriber only subscribes to Python topics
        }

        randomNum = rand.nextInt((1 - 0) + 1) + 0;
        if (randomNum == 1) {
            allLanguagesSubscriber.addSubscriber("Java", broker1);	//all subscriber, subscribes to both Java and Python
        } else {
            allLanguagesSubscriber.addSubscriber("Java", broker2);	//all subscriber, subscribes to both Java and Python
        }


        randomNum = rand.nextInt((1 - 0) + 1) + 0;
        if (randomNum == 1) {
            allLanguagesSubscriber.addSubscriber("Python", broker1);
        } else {
            allLanguagesSubscriber.addSubscriber("Python", broker2);
        }

        broker1.broadcast();
        broker2.broadcast();

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

        javaPublisher.publish(javaMsg4, broker1);
        javaPublisher.publish(javaMsg4, broker2);
        javaPublisher.publish(javaMsg5, broker1);
        javaPublisher.publish(javaMsg5, broker2);

        javaSubscriber.getMessagesForSubscriberOfTopic("Java", broker1);
        javaSubscriber.getMessagesForSubscriberOfTopic("Java", broker2);
        System.out.println("\nMessages of Java Subscriber now are: ");
        javaSubscriber.printMessages();
    }
}