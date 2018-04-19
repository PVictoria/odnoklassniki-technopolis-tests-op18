package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 18.04.2018.
 */
public class DescPresentPage extends PhotoPage implements DescInterface{ //Lena

    private static final By MARK_FRIENDS = By.xpath(".//*[@id = 'hook_Block_CreatePinsLinkPLRB']"); //Lena
    private static final By ADD_DESCRIPTION = By.xpath(".//*[contains(@id, 'plp_descrChgLnk')]");
    //private final static By CLEAR_DESC =  By.xpath(".//*[text() = 'Добавить описание']");

    public DescPresentPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(MARK_FRIENDS));
    }

    public boolean isDescEmpty() { // ??????
//        if (!isElementPresent(CLEAR_DESC)){
//            return true;
//        }
           return false;
    }

    public void clickAddDescription() { //Lena
        Assert.assertTrue("Не найдено добавление описания", isElementPresent(ADD_DESCRIPTION));
        driver.findElement(ADD_DESCRIPTION).click();
    }
}
