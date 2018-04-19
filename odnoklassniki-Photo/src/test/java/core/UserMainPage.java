package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMainPage extends HelperBase{
   public static final By TOOLBAR_USER_DROPDOWN =  By.xpath("//div[@id='hook_Block_ToolbarUserDropdown']/div/div/div/div");
    //public static final By TOOLBAR_USER_DROPDOWN = By.xpath(".//*[@class = 'ucard-mini_cnt_i']");
    public static final By LOGOUT = By.linkText("Выйти");
    public static final By LOGOFF = By.id("hook_FormButton_logoff.confirm_not_decorate");
    public static final By PHOTOS = By.xpath(".//*[contains(@data-l,'userPhotos')]");
    public static final By FIO = By.xpath(".//*[contains(@class, 'ic_nav_profile')]");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(PHOTOS ));
    }

    public PhotoMainPage clickPhotosOnToolbar() {
        if (isElementVisible(PHOTOS)){
            click(PHOTOS);
        }
        return new PhotoMainPage(driver);
    }

    public void clickLogout(){
//
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.elementToBeClickable(TOOLBAR_USER_DROPDOWN));

        Assert.assertTrue("Не дождались прогрузки кнопки выхода",
                explicitWait( ( ExpectedConditions.elementToBeClickable(driver.findElement(TOOLBAR_USER_DROPDOWN))),
                        15, 500) );


        click(TOOLBAR_USER_DROPDOWN);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(LOGOUT));
        click(LOGOUT);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(LOGOFF));
        click(LOGOFF);
    }
    public String getFIO() {
        String fio;
        fio = driver.findElement(FIO).getText();
        return fio;
    }
}