package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
    Properties config;

    public ConfigDataProvider(){
        File src = new File("./Data/data.properties");
            try(FileInputStream fs1 = new FileInputStream(src)) {
                config = new Properties();
                config.load(fs1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
    public String getURL(){
        return config.getProperty("url");
    }

    public String getUsername(){
        return config.getProperty("Username");
    }


}


