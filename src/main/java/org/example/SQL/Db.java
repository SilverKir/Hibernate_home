package org.example.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private  static  final String PASSWORD= "password"; //";

    public static void con() {
        try ( Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = con.createStatement();
          // statement.execute("DROP SCHEMA `test1`");
           statement.execute("CREATE SCHEMA IF NOT EXISTS test1");
            statement.execute("CREATE TABLE `test1`.`table`(`id` INT NOT NULL, `first_name` VARCHAR(45) NULL);");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
