import java.util.*;

public class Main {
    public static void main(String[] args) {
        // удалить все числа больше 10
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 1; i < 21; i++) {
            integers.add(i);
        }
        System.out.println(integers);
        Iterator<Integer> integerIterator = integers.iterator();
        while (integerIterator.hasNext()) {
            if (integerIterator.next() > 10) integerIterator.remove();
        }
        System.out.println(integers);
        System.out.println("");

        // вывести первый элемент, который нарушает возрастание длины строки
        // не пойму как сделать через foreach
        //ругается на previous так как в начале переборки отсутствует
        LinkedList<String> strings = new LinkedList<>();
        strings.add("q");
        strings.add("qw");
        strings.add("qwe");
        strings.add("q1");
        strings.add("qwer");
        System.out.println(strings);
        while (strings.listIterator().hasNext()) {
            if (strings.listIterator().next().length() >= strings.listIterator().previous().length())
            System.out.println(strings.listIterator().next());
        }
        System.out.println("");

        // помещать в списки элементы которые делятся на 2 и 3 или только на 3 а так же на 2 и все остальные
        // код работает, нули не добавляет, только не понятно, что значит все отсальные числа помимо 2, вообще все?
        ArrayList<Integer> integers1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            integers1.add((int) (Math.random() * 101));
        }
        System.out.println(integers1);
        ArrayList<Integer> integers2 = new ArrayList<>();
        ArrayList<Integer> integers3 = new ArrayList<>();
        for (int i = 0; i < integers1.size(); i++) {
            if (integers1.get(i) % 3 == 0 && integers1.get(i) % 2 == 0) {
                integers2.add(integers1.get(i));
                integers3.add(integers1.get(i));
            }
            else if (integers1.get(i) % 3 == 0) integers3.add(integers1.get(i));
            else if (integers1.get(i) % 2 == 0) integers2.add(integers1.get(i));
        }
        System.out.println("Числа делящиеся на 3");
        System.out.println(integers3);
        System.out.println("Числа делящиеся на 2");
        System.out.println(integers2);
    }
}

