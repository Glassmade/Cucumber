package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverService {

    private static DriverService instanceOfDriverUtilities;
    private WebDriver driver;

    public static DriverService getInstanceOfDriverUtilities()
    {
        if (instanceOfDriverUtilities == null)
        {
            instanceOfDriverUtilities = new DriverService();
        }
        return instanceOfDriverUtilities;
    }

    public WebDriver getDriver()
    {
        if (driver == null)
        {
            CreateDriver();
        }
        return driver;
    }

    private String GetDriverName()
    {
        Properties config = new Properties();
        String driverName = "";

        try
        {
            config.load(new FileInputStream("config.properties"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Config file is not present");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("Error when loading config file");
            e.printStackTrace();
        }

        for (String key : config.stringPropertyNames())
        {
            if (key.equals("browser"))
            {
                driverName = config.getProperty(key);
            }

        }
        return driverName;
    }

    private void CreateDriver()
    {
        String driverName = GetDriverName();



        switch (driverName)
        {
            case "Google Chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\dimko\\IdeaProjects\\chromedriver.exe");
                this.driver = new ChromeDriver();
                break;
            default:
                break;
        }
    }

}
