package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 18.04.2018.
 */
public class ClearDescPage extends PhotoPage implements DescInterface { //Lena

    private final static By CLEAR_DESC =  By.xpath(".//*[text() = 'Добавить описание']");
    private static final By MARK_FRIENDS = By.xpath(".//*[@id = 'hook_Block_CreatePinsLinkPLRB']");

    ClearDescPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(MARK_FRIENDS));
    }

    public boolean isDescEmpty() {
        if (isElementPresent(CLEAR_DESC)){
            return true;
        }
        return false;
    }
}
