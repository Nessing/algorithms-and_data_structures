package ru.nessing.lesson_5;

import java.util.*;

public class Anagram {
//    private Set<Thing> things = new TreeSet<>();


//    private Set<String> resultSet = new TreeSet<>();
    private List<Thing> resultSet = new ArrayList<>();

    private int weight;
    private int sum;

    private static List<Thing> things = Arrays.asList(
            new Thing("book", 1, 600),
            new Thing("binoculars", 2, 5000),
            new Thing("first aid kit", 4, 1500),
            new Thing("notebook", 6, 40000)
    );

    private Thing tempThing = things.get(1);

    public static void main(String[] args) {
        System.out.println(new Anagram().findAllStrings(things));

//        System.out.println(new Anagram().findAllStrings("abc"));
    }

    private List<Thing> findAllStrings(List<Thing> things) {
        resultSet.clear();

        find(things.size());

        return resultSet;
    }

    private void find(int length) {
        if (length == 0) {
            return;
        }

        for (int i = 0; i < length; i++) {
            weight = 0;
            sum = 0;
            find(length - 1);
            weight = 0;
            sum = 0;
            weight += things.get(i).getWeight();
            sum += things.get(i).getPrice();
//            if (weight == 6) {
//                System.out.println(things.get(i).getName() + " (" + things.get(i).getWeight() + ")" + " sum: " + sum);
//            } else {
                if (tempThing.equals(things.get(i))) continue;
                System.out.print(things.get(i).getName() + " (" + things.get(i).getWeight() + ")" + " + ");
                resultSet.add(things.get(i));
                rotate(length);
//            }
        }
    }

    private void rotate(int length) {
        tempThing = things.get(length - 1);
        int first = things.size() - length;

        Thing temp = things.get(first);
        int tempWeight = weight;
        for (int i = first + 1; i < things.size(); i++) {
            tempWeight = weight + things.get(i).getWeight();
            if (tempWeight <= 6) {
                sum += things.get(i).getPrice();
                System.out.println(things.get(i).getName() + " (" + things.get(i).getWeight() + ")" + " result " + tempWeight + " sum: " + sum);
            } else {
                tempWeight -= things.get(i).getWeight();
                continue;
            }
            things.set(i - 1, things.get(i));
        }
        things.set(things.size() - 1, temp);
    }
}
