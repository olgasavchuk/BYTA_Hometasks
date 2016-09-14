package module2.services;

import module2.models.Bouquet;
import module2.models.Flower;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Map;

public class DBService {

    private Connection connect = null;

    private void openConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/flowers_shop?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() throws SQLException {
        this.connect.close();
    }

    private int getID(String table, String filter, String value) {
        int id = 0;
        try {
            PreparedStatement preparedStatement = table.equals("bouquets")
                    ? connect.prepareStatement("select max(id) from " + table)
                    : connect.prepareStatement("select id from " + table + " where " + filter + " = ?");
            if (!table.equals("bouquets")) {
                preparedStatement.setString(1, value);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            id = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void writeBouquet(Bouquet bouquet, String customer_name) {
        try {
            this.openConnection();
            this.addBouquet(bouquet, customer_name);
            this.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addBouquet(Bouquet bouquet, String customerName) {
        try {
            int bouquetCost = bouquet.getCost();
            PreparedStatement preparedStatement = connect.prepareStatement("insert into bouquets values (null, ?, ?)");
            preparedStatement.setString(1, customerName);
            preparedStatement.setInt(2, bouquetCost);

            preparedStatement.executeUpdate();

            for (Map.Entry<Flower, Integer> entry : bouquet.getFlowers().entrySet()) {
                preparedStatement = connect.prepareStatement("insert into bouquet_flower values (?, ?, ?)");
                int bouquetId = this.getID("bouquets", "customer_name", customerName);
                preparedStatement.setInt(1, bouquetId);
                int flowerId = this.getID("flowers", "name", entry.getKey().getFlowerName());
                preparedStatement.setInt(2, flowerId);
                preparedStatement.setInt(3, entry.getValue());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getFlowerCost(String flower) {
        try {
            this.openConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select cost from flowers where flower_name = " + flower);
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
