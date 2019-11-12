package collections;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int low = 0, medium = 0, high = 0, urgent = 0;
        for (Message i: messageList) {
            if (i.getPriority().equals(MessagePriority.LOW)) low++;
            if (i.getPriority().equals(MessagePriority.MEDIUM)) medium++;
            if (i.getPriority().equals(MessagePriority.HIGH)) high++;
            if (i.getPriority().equals(MessagePriority.URGENT)) urgent++;
        }
        System.out.println("LOW - " + low + " MEDIUM - " + medium + " HIGH - " + high + " URGENT - " + urgent);
        System.out.println("");
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        Set<Message> set = new HashSet<>(messageList);
        for (Message r : set) {
            System.out.println("Код " + r.getCode() + " содержит " + Collections.frequency(messageList, r) + " сообщений");
            // неправильный вывод
            // актуально
        }
        System.out.println("");
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> messages = new HashSet<>(messageList);
        System.out.println("Количество уникальных сообщений - " + messages.size());
        System.out.println("");
    }


    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> linkedHashSet = new LinkedHashSet<>(messageList);
        List<Message> list = new ArrayList<>(linkedHashSet);
        return list;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println(messageList);
        List<Message> messages = new ArrayList<>(messageList);
        Iterator<Message> listIterator = messages.iterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getPriority().equals(priority)) {
                listIterator.remove();
            }
        }
        System.out.println(messages);
        System.out.println("");
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println(messageList);
        List<Message> messages = new ArrayList<>(messageList);
        Iterator<Message> listIterator = messages.iterator();
        while (listIterator.hasNext()) {
            if (!listIterator.next().getPriority().equals(priority)) {
                listIterator.remove();
            }
        }
        System.out.println(messages);
        System.out.println("");
    }

    public static void main(String[] args) {
        // вызов методов
        List<Message> messages = MessageGenerator.generate(10);
        System.out.println(messages);
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        System.out.println("");
        removeEach(messages,MessagePriority.URGENT);
        removeOther(messages,MessagePriority.URGENT);

    }


}
