package module1.list;

import module1.reader.Reader;
import java.util.ArrayList;

public class List {

    ArrayList<String> list = new ArrayList<>();

    public List() throws Exception{
        Reader reader = new Reader();
        String value;
        System.out.println("Enter values. to finish enter \"fun\" ");
        do {
            value = reader.getLine();
            if (!value.equals("fun")) {
                list.add(value);
            }
        } while (!value.equals("fun"));
    }

    public void showList() {
        for (String aList : this.list) {
            System.out.println(aList);
        }
    }

    public void showListElement(int i) {
        System.out.println(this.list.get(i));
    }

    public int getListSize() {
        return this.list.size();
    }

    //Sorting with Bubble Method
    public ArrayList sortByStringLength() {
        String s;
        for (int i = 0; i < this.list.size(); i++) {
            for (int j = 0; j < this.list.size() - i - 1; j++) {
                if (this.list.get(j).length() > this.list.get(j+1).length()) {
                    s = this.list.get(j+1);
                    this.list.set(j+1, this.list.get(j));
                    this.list.set(j, s);
                }
            }
        }
        return this.list;
    }

    public void revertStringsOfList() {
        StringBuffer value;
        for (int i = 0; i < this.list.size(); i++) {
            value = new StringBuffer(this.list.get(i));
            this.list.set(i, value.reverse().toString());
        }
    }

    public String[] convertToArray() {
        String[] array = new String[this.list.size()];
        this.list.toArray(array);
        return array;
    }

    public int countOfLettersInStringOfList(int k, String letterType) {
        String alphabet = "";
        if (letterType.equals("vowel")) {
            alphabet = "A,a,E,e,I,i,O,o,U,u,Y,y";
        } else if (letterType.equals("consonant")) {
            alphabet = "B,b,C,c,D,d,F,f,G,g,H,h,J,j,K,k,L,l,M,m,N,n,P,p,Q,q,R,r,S,s,T,t,V,v,W,w,X,x,Y,y,Z,z";
        }
        int count = 0;
        char [] alphabetArray = alphabet.toCharArray();
        char [] stringArray = this.list.get(k).toCharArray();
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < alphabetArray.length; j++) {
                if (stringArray[i] == alphabetArray[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public String getListElement(int i) {
        return this.list.get(i);
    }

    public void setListElement(int i, String value) {
        this.list.set(i, value);
    }
}
