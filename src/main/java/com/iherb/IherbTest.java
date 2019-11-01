package com.iherb;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class IherbTest {

   @Test
   public void addProductToCartTest(){
       System.setProperty("webdriver.gecko.driver", "/Users/maria_shukhter/Desktop/selenium");
       System.setProperty("webdriver.chrome.driver", "/Users/maria_shukhter/Desktop/selenium/chromedriver");

       WebDriver driver = new ChromeDriver();

       driver.navigate().to("https://www.iherb.com/");
       Assert.assertTrue("tile should start with iHerb.com",
              driver.getTitle().startsWith("iHerb.com"));

       System.out.println("The website is opened");

       driver.navigate().to("https://www.iherb.com/c/supplements");
       Assert.assertTrue("title should start with Supplements",
               driver.getTitle().startsWith("Supplements"));

       System.out.println("The page is opened");

       ((ChromeDriver) driver).findElementByCssSelector("a[href='https://www.iherb.com/pr/California-Gold-Nutrition-Omega-3-Premium-Fish-Oil-100-Fish-Gelatin-Softgels/62118']").click();

       ((ChromeDriver) driver).findElementByCssSelector("button[data-product-id='62118']").click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       System.out.println("The product in the cart");


      ((ChromeDriver) driver).findElementsByCssSelector("a[href='https://checkout.iherb.com/EditCart']").get(1).click();

       System.out.println("The cart is opened");


       Boolean isPresent = ((ChromeDriver) driver).findElementsByXPath("//*[contains(text(), 'MLI-00952')]").size()>0;
       Assert.assertTrue(isPresent);

       System.out.println("The product is found in the cart");


       driver.close();
       driver.quit();


   }


}
