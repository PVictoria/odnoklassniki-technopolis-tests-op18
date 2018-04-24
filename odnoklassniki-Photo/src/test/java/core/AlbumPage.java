package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AlbumPage extends HelperBase {
    public TopToolBar topToolBar = new TopToolBar(driver);
    public ToolBar toolBar = new ToolBar(driver);

    private static final By EDIT_ALBUM = By.xpath(".//*[text() = 'Редактировать, изменить порядок']");
    public static final By MIDDLE_PART_OF_PAGE = By.xpath(".//*[@id= 'hook_Block_MiddleColumn']");

    public AlbumPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(MIDDLE_PART_OF_PAGE));
    }

    public EditAlbumPage clickEdit() {
        Assert.assertTrue("Не найдено редактировать", isElementPresent(EDIT_ALBUM));
        driver.findElement(EDIT_ALBUM).click();
        return new EditAlbumPage(driver);
    }

    public PhotoPage openPhotoById(String photoId) {
        By OPEN = By.xpath(".//*[contains(@id, '" + photoId + "')]");
        Assert.assertTrue("Не найдено фото", isElementPresent(OPEN) && driver.findElement(OPEN).isDisplayed());
        click(OPEN);

        return new PhotoPage(driver);
    }
    public boolean isPhotoPresent(String photoId){
        By PHOTO = By.xpath(".//*[contains(@id, '" + photoId + "')]");
        return isElementPresent(PHOTO);

    }

}
