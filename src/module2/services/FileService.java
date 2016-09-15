package module2.services;

import module2.models.Bouquet;
import module2.models.Flower;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class FileService {

    public final static String folderPath = "src/module2/results/txt";
    private File file;
    private File dir;


    public FileService() {
        this.dir = new File(folderPath);
        if (!this.dir.exists()) this.dir.mkdir();
        String date = new SimpleDateFormat("ddMM-hhmmss").format(new Date());
        this.file = new File(this.dir + "/" + date + ".txt");
    }

    public void writeToFile(Bouquet bouquet) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(this.file));
            for (Map.Entry<Flower, Integer> entry : bouquet.getFlowers().entrySet()) {
                writer.write(entry.getKey().getFlowerName() + ":" + entry.getValue() + "\n");
            }
            writer.write("TOTAL:" + bouquet.getCost());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object[] readFromFile(String file) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(folderPath + "/" + file));
            return reader.lines().toArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String[] getFilesList() {
        return dir.list();
    }
}
