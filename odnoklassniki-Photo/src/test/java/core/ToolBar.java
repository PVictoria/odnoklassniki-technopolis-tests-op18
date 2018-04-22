package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.krb5.KrbException;

import static sun.security.krb5.Config.refresh;


public class ToolBar extends HelperBase {
   // WebElement element;
    public static  final By PHOTO_TAB= By.xpath (".//*[contains(@hrefattrs, 'NavMenu_User_Photos')]");
    public ToolBar(WebDriver driver) {
       super(driver);
      // element =  driver.findElement(By.id("mainTopContentRow"));

    }
    public void check(){
        //todo

    }


    public PhotoMainPage openPhotoMainPage() throws InterruptedException, KrbException {
//       WebElement webElement = driver.findElement(PHOTO_TAB);
//        if(webElement.isDisplayed()) {
//            webElement.click();
//        }

        refresh();
        (new WebDriverWait(driver, 30))
                .until( ExpectedConditions.elementToBeClickable(PHOTO_TAB));

        Assert.assertTrue("Не найдена вкладка фото",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PHOTO_TAB),
                        15, 500) );



        click(PHOTO_TAB);
        return new PhotoMainPage(driver);

    }
}
