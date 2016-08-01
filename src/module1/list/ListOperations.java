package module1.list;

import java.util.ArrayList;

public class ListOperations {

    public static void main(String[] args) throws Exception {
        List list = new List();

        System.out.println("Change by places first and last letters in each second string of list ");
        changeFirstLastLetterInStringOfList(list);
        list.showList();

        System.out.println("Sort list by string length:");
        list.sortByStringLength();
        list.showList();

        System.out.println("Find the second by length string in a list:");
        System.out.println(secondByLengthStringOfList(list));
        System.out.println();

        System.out.println("Revert strings of list: ");
        list.revertStringsOfList();
        list.showList();

        System.out.println("Sort list by count of vowels in string");
        sortByNumberOfLetters(list, "vowel");
        list.showList();

        System.out.println("Sort list by count of consonants in string");
        sortByNumberOfLetters(list, "consonant");
        list.showList();

    }

    public static void sortByNumberOfLetters(List list, String letter) {
        String s;
        int k,l;
        for (int i = 0; i < list.getListSize(); i++) {
            for (int j = 0; j < list.getListSize() - i - 1; j++) {
                if (list.countOfLettersInStringOfList(j, letter) > list.countOfLettersInStringOfList(j + 1, letter)) {
                    s = list.getListElement(j+1);
                    list.setListElement(j + 1, list.getListElement(j));
                    list.setListElement(j, s);
                }
            }
        }
    }

    public static String secondByLengthStringOfList(List list) {
        String result = "";
        int error = 1;
        for (int i = list.getListSize() - 1; i > 0; i--) {
            if (list.getListElement(i).length() > list.getListElement(i - 1).length()) {
                result = list.getListElement(i - 1);
                error = 0;
                break;
            }
        }
        if (error == 1) System.out.println("All strings are equal");
        return result;
    }

    //TODO string -> char -> string hernya
    public static void changeFirstLastLetterInStringOfList(List list) {
        char [] stringArray;
        char s;
        for (int i = 0; i < list.getListSize(); i++) {
            if ((i+1)%2 == 0) {
                stringArray = list.getListElement(i).toCharArray();
                s = stringArray[0];
                stringArray[0] = stringArray[stringArray.length - 1];
                stringArray[stringArray.length - 1] = s;
                list.setListElement(i, stringArray.toString());
            }

        }
    }
}
