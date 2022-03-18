package models;

import java.io.FileInputStream;
import java.util.Properties;

public class User {

    private String username;
    private String password;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }


    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }



    public void ReadPropertiesFile() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setUsername(prop.getProperty("username"));
        setPassword(prop.getProperty("password"));


    }

}
