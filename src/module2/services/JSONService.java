package module2.services;

import com.google.gson.*;
import module2.interfases.WritableReadable;
import module2.models.Bouquet;
import module2.models.Flower;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class JSONService implements WritableReadable{

    public final static String folderPath = "src/module2/resultsJSON";
    private File file;

    public JSONService() {
        File dir = new File(folderPath);
        if (!dir.exists()) dir.mkdir();
        String date = new SimpleDateFormat("ddMM-hhmmss").format(new Date());
        this.file = new File(dir + "/" + date + ".json");
    }

    @Override
    public void writeToSource(Bouquet bouquet, Object... arguments) {
        BufferedWriter writer;

        JsonObject bouquetJson = new JsonObject();
        bouquetJson.addProperty("cost", bouquet.getPrice());
        JsonArray flowers = new JsonArray();

        for (Map.Entry< Flower, Integer> entity : bouquet.getFlowers().entrySet()) {
            JsonObject flower = new JsonObject();
            flower.addProperty("name", entity.getKey().getFlowerName());
            flower.addProperty("qty", entity.getValue());
            flowers.add(flower);
        }

        bouquetJson.add("flowers", flowers);

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        try {
            writer = new BufferedWriter(new FileWriter(this.file));
            writer.write(gson.toJson(bouquetJson));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromSource() {
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            while ((line = reader.readLine()) != null) System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
