package designpatterns.behavioral.iterator;

public class Test {
    public static void main(String[] args)
    {
        Topic[] topics = new Topic[5];
        topics[0] = new Topic("Java");
        topics[1] = new Topic("Python");
        topics[2] = new Topic("C");
        topics[3] = new Topic("Ruby");
        topics[4] = new Topic("C#");


        Iterator<Topic> iterator = new TopicIterator(topics);

        while(iterator.hasNext()) {
            Topic currentTopic = iterator.next();
            System.out.println(currentTopic.getName());
            if(iterator.currentItem()==topics[3])
                break;
        }
        System.out.println("Iterator reset to first Position");
        iterator.reset();
        while(iterator.hasNext()) {
            Topic currentTopic = iterator.next();
            System.out.println(currentTopic.getName());
        }
    }
}
