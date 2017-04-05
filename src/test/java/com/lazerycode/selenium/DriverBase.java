package com.lazerycode.selenium;

import com.lazerycode.selenium.config.DriverFactory;

import org.junit.After;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;

public class DriverBase {

    private static DriverFactory driverFactory;

	@ClassRule
	public static ExternalResource resource = new ExternalResource() {
	
		
		@Override
		protected void before() throws Throwable {
			System.out.println("external resource");
			driverFactory = new DriverFactory();
		}
			
		@Override
		protected void after() {
			driverFactory.quitDriver();
			
		}
    };

    public static WebDriver getDriver() throws Exception {
        return driverFactory.getDriver();
    }

    @After
    public void clearCookies() throws Exception {
        getDriver().manage().deleteAllCookies();
    }
}