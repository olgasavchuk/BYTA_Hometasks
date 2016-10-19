package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("--- Adding to the beginning of the list ---");
        addTiming("beginning", "ArrayList", arrayList);
        addTiming("beginning", "LinkedList", linkedList);

        System.out.println("\n--- Adding to the end of the list ---");
        addTiming("end", "LinkedList", arrayList);
        addTiming("end", "ArrayList", linkedList);

        System.out.println("\n--- Removing from the beginning of the list ---");
        removeTiming("beginning", "ArrayList", arrayList);
        removeTiming("beginning", "LinkedList", linkedList);

        System.out.println("\n--- Removing from the end of the list ---");
        removeTiming("end", "ArrayList", arrayList);
        removeTiming("end", "LinkedList", linkedList);

        System.out.println("\n--- Searching element ---");
        searchingTiming("ArrayList", arrayList);
        searchingTiming("LinkedList", linkedList);
    }

    private static void removeTiming(String place, String listType, List<Integer> list) {
        long startTime = 0;
        long endTime = 0;

        switch (place) {
            case "beginning":
                startTime = System.currentTimeMillis();
                list.remove(0);
                endTime = System.currentTimeMillis();
                break;
            case "end":
                startTime = System.currentTimeMillis();
                list.remove(list.size() - 1);
                endTime = System.currentTimeMillis();
                break;
        }
        System.out.println("Timing for " + listType + " is " + (endTime - startTime) + " ms");
    }

    private static void searchingTiming(String listType, List<Integer> list) {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1E5; i++) {
            if (list.get(i) == 9999) break;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Timing for " + listType + " is " + (endTime - startTime) + " ms");

    }

    public static void addTiming(String place, String listType, List<Integer> list) {
        long startTime = 0;
        long endTime = 0;

        switch (place) {
            case "beginning":
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 1E5; i++) {
                    list.add(0, i);
                }
                endTime = System.currentTimeMillis();
                break;
            case "end":
                startTime = System.currentTimeMillis();
                for (int i = 0; i < 1E5; i++) {
                    list.add(i);
                }
                endTime = System.currentTimeMillis();
                break;
        }
        System.out.println("Timing for " + listType + " is " + (endTime - startTime) + " ms");
    }
}
