package dbCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBCore <T> {

    static String url;
    static String username;
    static String password;

    public DBCore(){
        readFromConfig();
    }

    private ArrayList<T> resultData = new ArrayList<T>();


    /**
     * Метод, читающий из Базы Данных
     *
     * @param query - SQL-запрос
     * @param tClass - Тип возвращаемого значения из БД (Тип Data-класса)
     *
     * @return - Возвращает ArrayList исходя из запроса
     */

    public ArrayList dbRead(String query, Class <T> tClass) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection connection = DriverManager.getConnection(url, username, password)) {

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()){
                    resultData.add(serialize(resultSet, tClass));
                }

                resultSet.close();
                statement.close();
            } catch (IllegalAccessException | InstantiationException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return resultData;
    }


    /**
     * Метод, изменяющий Базу Данных
     *
     * @param query - SQL-запрос
     */

    public void dbWrite(String query){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);

                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод для сериализации данных из БД
     * (т.е. метод берёт строку данных из БД и переводит эти данные в объект Data-класса)
     *
     * @param resultSet - строка из БД
     * @param tClass - Data-класс
     * @param <T> - Тип Data-класса
     *
     * @return - Возвращает объект типа Data-класс
     *
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     * @throws SQLException
     */

    private <T> T serialize (ResultSet resultSet, Class<T> tClass)
            throws IllegalAccessException, InstantiationException,
            NoSuchFieldException, SQLException {

        T template = tClass.newInstance();
        for (var item: tClass.getFields()){
            var a = resultSet.getObject(item.getName());
            tClass.getField(item.getName()).set(template, a);
        }

        return template;
    }


    /**
     * Метод, читающий конфигурации для БД из config.properties
     */

    public static void readFromConfig(){
        Properties properties = new Properties();
        try{
            FileInputStream inputStream = new FileInputStream(new File("src\\main\\resources\\config.properties"));
            properties.load(inputStream);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
