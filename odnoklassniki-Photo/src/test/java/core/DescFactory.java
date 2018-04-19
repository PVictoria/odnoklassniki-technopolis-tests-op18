package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by User on 18.04.2018.
 */
public class DescFactory { //Lena

    private final static By CLEAR_DESC =  By.xpath(".//*[text() = 'Добавить описание']");
    public DescInterface getPage(WebDriver driver) {
        //условие
        if (isDescEmpty(driver)) {
            return new ClearDescPage(driver);
        } else {
            return new DescPresentPage(driver);
        }
    }

    private boolean isDescEmpty(WebDriver driver) {
        if (driver.findElement(CLEAR_DESC).isDisplayed()){
            return  true;
        }
        return false;
    }

}
