package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 18.04.2018.
 */
public class ClearDescPage extends PhotoPage implements DescInterface { //Lena

    private static final By PHOTO = By.xpath(".//*[contains(@id, '__plpcte_target')]");

    ClearDescPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {

        Assert.assertTrue("Не дождались прогрузки страницы Фото",
                explicitWait( ( ExpectedConditions.visibilityOfAllElements(driver.findElements(PHOTO))),
                        5, 500) );

       /* (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(PHOTO));*/
    }
}
