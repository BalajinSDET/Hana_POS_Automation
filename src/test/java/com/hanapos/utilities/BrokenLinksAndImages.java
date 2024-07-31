package com.hanapos.utilities;

import java.net.URL;
import java.util.List;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.hanapos.seleniumProjectBase.TestBaseClass;


public class BrokenLinksAndImages extends TestBaseClass{
	
	public void brokenLinks() throws Exception {
		logger.info("***Validating Broken Links***");
		List<WebElement> allLinks=getDriver().findElements(By.tagName("a"));
		logger.info("No.of Links in the Page"+allLinks.size());
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		for(WebElement link:allLinks) {
			if(link.getAttribute("a")!=null) {
				activeLinks.add(link);
			}
		}
		for(int i=0;i<activeLinks.size();i++) {
			HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(i).getAttribute("href")).openConnection();
			connection.connect();
			int responseCode=connection.getResponseCode();
			String responseMessage=connection.getResponseMessage();
			connection.disconnect();
			logger.info("URL"+activeLinks.get(i).getAttribute("href")+" Response Code=====> "+responseCode+" Response Message=====> "+responseMessage);
		}
		
	}
	
	public void brokenImages() throws Exception{
		
		logger.info("***Validating Broken Images");
		List<WebElement> allImages = getDriver().findElements(By.tagName("img"));
		logger.info("No.of Images in the Page" + allImages.size());
		List<WebElement> activeImages = new ArrayList<WebElement>();
		for(WebElement image : allImages) {
			if(image.getAttribute("img")!=null) {
				activeImages.add(image);
			}
		}
		for(int i=0;i<activeImages.size();i++) {
			HttpURLConnection connection=(HttpURLConnection)new URL(activeImages.get(i).getAttribute("href")).openConnection();
			connection.connect();
			int responseCode=connection.getResponseCode();
			String responseMessage=connection.getResponseMessage();
			connection.disconnect();
			logger.info("URL"+activeImages.get(i).getAttribute("href")+" Response Code=====> "+responseCode+" Response Message=====> "+responseMessage);
		}
		
	}

}
