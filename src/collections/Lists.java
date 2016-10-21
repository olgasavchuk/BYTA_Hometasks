package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("\n--- Adding to the beginning of the list ---");
        timing(arrayList, "addToBeginning", "ArrayList");
        timing(linkedList, "addToBeginning", "LinkedList");

        System.out.println("\n--- Adding to the end of the list ---");
        timing(arrayList, "addToEnd", "ArrayList");
        timing(linkedList, "addToEnd", "LinkedList");

        System.out.println("\n--- Removing from the beginning of the list ---");
        timing(arrayList, "removeFromList", "ArrayList");
        timing(linkedList, "removeFromList", "LinkedList");

        System.out.println("\n--- Removing from the end of the list ---");
        timing(arrayList, "removeFromEnd", "ArrayList");
        timing(linkedList, "removeFromEnd", "LinkedList");

        System.out.println("\n--- Searching element ---");
        timing(arrayList, "search", "ArrayList");
        timing(linkedList, "search", "LinkedList");
    }

    public static void timing(List<Integer> list, String operation, String listType) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        switch (operation) {
            case "addToEnd":
                addToList(list, null);
                break;
            case "addToBeginning":
                addToList(list, 0);
                break;
            case "removeFromList":
                removeFromList(list, 0);
                break;
            case "removeFromEnd":
                removeFromList(list, list.size() - 1);
                break;
            case "search":
                searchElement(list, 9999);
                break;
        }
        endTime = System.currentTimeMillis();
        System.out.println(listType + ": " + (endTime - startTime) + " ms");
    }

    private static void removeFromList(List<Integer> list, int index) {
        list.remove(index);
    }

    public static void addToList (List<Integer> list, Integer index) {
        for (int i = 0; i < 1E5; i++) {
            if (index == null) {
                list.add(i);
            } else {
                list.add(index, i);
            }
        }
    }

    private static boolean searchElement(List<Integer> list, Integer value) {
        for (int i = 0; i < 1E5; i++) {
            if (list.get(i) == value) return true;
        }
        return false;
    }
}
