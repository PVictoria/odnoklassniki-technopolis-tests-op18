package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

/**
 * Created by User on 15.04.2018.
 */
public class PhotoPage extends HelperBase {

    private static final By ADD_DESCRIPTION = By.xpath(".//*[contains(@class, 'tico_txt')]");  //Lena //добавить фабрику?
    private static final By SAVE_DESCRIPTION = By.xpath(".//*[contains(@value, 'Сохранить')]"); //Lena
    private static final String INPUT_DESCRIPTION = "plp_descrInp"; //Lena
    private static final By CLOSE_PHOTO = By.xpath(".//*[contains(@class, 'js-photoLayerClose ic photo-layer_close')]"); //Lena
    private static final By MENU_LOGOUT = By.xpath(".//*[@class = 'ucard-mini_cnt_i']"); //Lena
    private static final By LOGOUT = By.xpath(".//*[@data-l = 't,logoutCurrentUser']"); //Lena
    private static final By CLICK_LIKE = By.xpath("//*[contains(@class,'photo-layer_klass_link')]");

    //private static final By MARK_FRIENDS = By.xpath(".//*[text() = 'Отметить друзей']"); //Lena
    private static final By MARK_FRIENDS = By.xpath(".//*[@id = 'hook_Block_CreatePinsLinkPLRB']"); //Lena
    private static final By MARK_MESSAGE = By.xpath(".//*[text() = 'Чтобы отметить человека, наведите на него курсор и нажмите левую кнопку мыши.']"); //Lena
    private static final By CLICK_ON_PHOTO = By.xpath(".//*[@id = '__plpcte_target']"); //Lena
    private static final By CHOOSE_SELF = By.xpath(".//*[@id = 'plpp_markSelf']"); //Lena
    private static final By DONE = By.xpath(".//*[@class = 'js-cancelEditMode button-pro']"); //Lena

    private static final By ADD_COMMENT = By.xpath(".//*[contains(@class,'itx js-comments_add')]");
    private static final By CLICK_ADD_COMMENT = By.xpath(".//button[contains(@class,'button-pro form-actions_yes')]");
    //private static final By CHECK_LIKE = By.xpath("//*[contains(@data-flags, 'react')]//child::*[contains(@class, 'widget  __active __no-o __wide-count')]");
    private static final By CHECK_LIKE = By.xpath("//*[contains(@class, 'photo-layer_klass __active __anim')]");
    private static final By DELETE_COM = By.xpath("(//a[@title='Удалить'])[last()]");
    private static final By WAIT_FOR_DEL_COM = By.xpath("(//*[@class='photo-layer_bottom_l'])");

    public PhotoPage(WebDriver driver) {
        super(driver);
    }

    protected void check() { //Пожалуйста, переименуй, путается с абстрактным check в helperbase //Lena
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(MARK_FRIENDS));
    }

    public void clickAddDescription() { //Lena
        Assert.assertTrue("Не найдено добавление описания", isElementPresent(ADD_DESCRIPTION));
        driver.findElement(ADD_DESCRIPTION).click();
    }

    public void typeDescrName(String descroption) { //Lena
        type(descroption, By.id(INPUT_DESCRIPTION));
    }

    public void clickSaveDescription() { //Lena
        Assert.assertTrue("Не найдена кнопка сохраннения описания", isElementPresent(SAVE_DESCRIPTION));
        driver.findElement(SAVE_DESCRIPTION).click();
    }

    public boolean isAddDescription(String description) { //Lena
        final By DESCRIPTION_CREATED = By.xpath(".//*[text() = '" + description + "' ]");
        //  Assert.assertTrue("Альбом не создан", isElementPresent(ALBUM_PRESENT));
        return isElementPresent(DESCRIPTION_CREATED);
        //должен возвращать boolean
    }

    public void closePhoto(){ //Lena
        driver.findElement(CLOSE_PHOTO).click();
    }

    public void phLogout() throws InterruptedException { //Lena
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
    ///////////////////////////////////////////////////////////////

    public void clickMarkFriends() { //Lena
        Assert.assertTrue("Не найдена кнопка отметить друзей", isElementPresent(MARK_FRIENDS));
        click(MARK_FRIENDS);
        //driver.findElement(MARK_FRIENDS).click();
    }
    /*public void clickOnMarkMessage() { //Lena
        Assert.assertTrue("Не найдена кнопка отметить друзей", isElementPresent(MARK_MESSAGE));
        driver.findElement(MARK_MESSAGE).click();
    }*/
    public void clickOnPhoto() { //Lena
        Assert.assertTrue("Не найдено фото", isElementVisible(CLICK_ON_PHOTO));
        driver.findElement(CLICK_ON_PHOTO).click();
    }
    public void clickOnSelf() { //Lena
        Assert.assertTrue("Не найдено отметить себя", isElementPresent(CHOOSE_SELF));
        driver.findElement(CHOOSE_SELF).click();
    }
    public void clickDone() { //Lena
        Assert.assertTrue("Не найдено готово", isElementPresent(DONE));
        driver.findElement(DONE).click();
    }

    public boolean isMarkSelf(String login, String password) { //Lena
        final By MARK_SELF_CREATED = By.xpath(".//*[text() = '" + login + " " + password + "' ]");
        //  Assert.assertTrue("Альбом не создан", isElementPresent(ALBUM_PRESENT));
        return isElementPresent(MARK_SELF_CREATED);
        //должен возвращать boolean
    }
    ///////////////////////////////////////////////////////////////


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

    public void clickLike(){
        Assert.assertTrue("Не найдена кнопка лайка", isElementPresent(CLICK_LIKE));
        click(CLICK_LIKE);
    }

    public boolean isLike(){
        return isElementPresent(CHECK_LIKE);
    }

    public  void delAllCom(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(WAIT_FOR_DEL_COM));
        Assert.assertTrue("Не найдена кнопка удалить", isElementPresent(DELETE_COM));
        Actions builder;
        builder = new Actions(driver);
        builder.moveToElement(driver.findElement(DELETE_COM)).click().build().perform();

    }
}

