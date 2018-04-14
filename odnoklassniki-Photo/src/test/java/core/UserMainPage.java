package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMainPage extends HelperBase{

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        //todo
        //думаю, тут должна быть проверка того, что кнопка фото кликабельна (прогрузиласт и мы можемнажать)
    }

    public void clickGroupsOnToolbar() {
        click(By.xpath(".//*[contains(@data-l,'userAltGroup')]"));
    }
    public void clickPhotosOnToolbar() {
        click(By.xpath(".//*[contains(@data-l,'userPhotos')]"));
    }

    public void clickLogout(){
        By ToolbarUserDropdown =  By.xpath("//div[@id='hook_Block_ToolbarUserDropdown']/div/div/div/div");
        By LogOut = By.linkText("Выйти");
        By LogOff = By.id("hook_FormButton_logoff.confirm_not_decorate");

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(ToolbarUserDropdown));
        click(ToolbarUserDropdown);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(LogOut));
        click(LogOut);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(LogOff));
        click(LogOff);
    }


}