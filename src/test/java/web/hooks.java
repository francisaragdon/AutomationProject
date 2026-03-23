package web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import web.factory.DriverManager;
import utils.ConfigReader;

public class hooks {

    private final DriverManager driverManager;

    public hooks(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Before
    public void setup() {
        driverManager.initDriver(ConfigReader.getBrowser());

    }

    @After
    public void tearDown(){
        driverManager.quitDriver();
    }
}
