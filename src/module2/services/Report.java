package module2.services;

public class Report {

    private int totalCost = 0;

    public Report() {
    }

    public int getReport(String[] fileList) {
        for (String filePath : fileList) {
            Object[] content = FileService.readFromFile(filePath);

            for (Object lineObject : content) {
                String line = lineObject.toString();
                String[] result = line.split(":");
                if (result[0].contains("TOTAL")) this.totalCost += Integer.parseInt(result[1]);
            }
        }
        return this.totalCost;
    }
}
