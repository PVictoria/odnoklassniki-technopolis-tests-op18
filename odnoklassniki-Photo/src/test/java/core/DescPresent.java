package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 18.04.2018.
 */
public class DescPresent extends HelperBase implements DescInterface{ //Lena

    private static final By MARK_FRIENDS = By.xpath(".//*[@id = 'hook_Block_CreatePinsLinkPLRB']"); //Lena

    private final static By CLEAR_DESC =  By.xpath(".//*[text() = 'Добавить описание']");
    public DescPresent(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(MARK_FRIENDS));
    }

    public boolean isDescEmpty() {
        if (!isElementPresent(CLEAR_DESC)){
            return true;
        }
        return false;
    }
}
