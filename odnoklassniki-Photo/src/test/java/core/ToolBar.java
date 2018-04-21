package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class ToolBar extends HelperBase {
   // WebElement element;
    public static  final By PHOTO_TAB= By.xpath (".//*[contains(@hrefattrs, 'NavMenu_User_Photos')]");
    public ToolBar(WebDriver driver) {
       super(driver);
      // element =  driver.findElement(By.id("mainTopContentRow"));

    }
    public void check(){

    }


    public PhotoMainPage openPhotoMainPage(){
//       WebElement webElement = driver.findElement(PHOTO_TAB);
//        if(webElement.isDisplayed()) {
//            webElement.click();
//        }
        Assert.assertTrue("Не найдена вкладка фото", (driver.findElement(PHOTO_TAB).isDisplayed()));
//        (new WebDriverWait(driver, 30))
//                .until(ExpectedConditions.elementToBeClickable(PHOTO_TAB));
//

        click(PHOTO_TAB);
        return new PhotoMainPage(driver);

    }
}
