package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

/**
 * Created by User on 15.04.2018.
 */
public class PhotoPage extends HelperBase {

    private static final By ADD_DESCRIPTION = By.xpath(".//*[contains(@class, 'tico_txt')]");
    private static final By SAVE_DESCRIPTION = By.xpath(".//*[contains(@value, 'Сохранить')]");
    private static final String INPUT_DESCRIPTION = "plp_descrInp";
    private static final By CLOSE_PHOTO = By.xpath(".//*[contains(@class, 'js-photoLayerClose ic photo-layer_close')]");
    private static final By MENU_LOGOUT = By.xpath(".//*[@class = 'ucard-mini_cnt_i']");
    private static final By LOGOUT = By.xpath(".//*[@data-l = 't,logoutCurrentUser']");
    private static final By ADD_COMMENT = By.xpath(".//*[contains(@class,'itx js-comments_add')]");

    private static final By CLICK_ADD_COMMENT = By.xpath(".//button[contains(@class,'button-pro form-actions_yes')]");
    public PhotoPage(WebDriver driver) {

        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(ADD_DESCRIPTION));
    }

    public void setAddComment(String comText){ //Таня
        type(comText,ADD_COMMENT);
    }

    public void clickSetAddComment(){ // Таня
        Assert.assertTrue("Не найдена кнопка добавления коммента", isElementPresent(ADD_COMMENT));
        click(CLICK_ADD_COMMENT);
    }

    public boolean isAddComment(String com) {
        final By COMMENT_CREATED = By.xpath(".//*[text() = '" + com + "' ]");
        return isElementPresent(COMMENT_CREATED);
    }

    public void clickAddDescription() {
        Assert.assertTrue("Не найдено добавление описания", isElementPresent(ADD_DESCRIPTION));
        driver.findElement(ADD_DESCRIPTION).click();
    }

    public void typeDescrName(String descroption) {
        type(descroption, By.id(INPUT_DESCRIPTION));
    }

    public void clickSaveDescription() {
        Assert.assertTrue("Не найдена кнопка сохраннения описания", isElementPresent(SAVE_DESCRIPTION));
        driver.findElement(SAVE_DESCRIPTION).click();
    }

    public boolean isAddDescription(String description) {
        final By DESCRIPTION_CREATED = By.xpath(".//*[text() = '" + description + "' ]");
        //  Assert.assertTrue("Альбом не создан", isElementPresent(ALBUM_PRESENT));
        return isElementPresent(DESCRIPTION_CREATED);
        //должен возвращать boolean
    }

    public void phLogout() throws InterruptedException {
        driver.findElement(CLOSE_PHOTO).click();
       //sleep(1000);
        driver.findElement(MENU_LOGOUT).click();
       // sleep(1000);
        driver.findElement(LOGOUT).click();

        /*(new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(MENU_LOGOUT));
        click(MENU_LOGOUT);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(LOGOUT));
        click(LOGOUT);*/

    }
}
