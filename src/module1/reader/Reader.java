package module1.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    BufferedReader reader;

    public Reader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getLine() {
        String result = null;
        try {
             result = this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
