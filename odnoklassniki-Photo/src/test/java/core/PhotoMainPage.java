package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

public class PhotoMainPage extends HelperBase {
    public TopToolBar topToolBar = new TopToolBar(driver);
    public ToolBar toolBar = new ToolBar(driver);
    private static final By CREATE_ALBUM_BUTTON = By.id("hook_FormButton_button_album_create");
    private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@class, 'portlet_h_ac' )]");
    public static final By OPEN_PHOTO_FOR_LIKE = By.xpath(".//*[contains(@id, 'img_866106130788')]");
    public static final By OPEN_PHOTO_FOR_COM = By.xpath(".//*[contains(@id, 'img_865777208163')]");
    public static final By ALL_ALBUMS = By.xpath(".//*[contains(@id, 'UserAlbumStreamBlock')]/descendant::li[@class = 'ugrid_i']");
    public static final By OPEN_ALBUM = By.xpath(".//*[contains(@id,'hook_Block_PhotoCardBlock')]//*[@class='photo-album_cnt']");
    private static final By PHOTO_ADD_BUTTON = By.xpath(".//input[@type = 'file' and @name = 'photo']");
    private static final By USER_MAIN_PAGE = By.id("topPanelLeftCorner");
    public static final By MIDDLE_PART_OF_PAGE = By.xpath(".//*[@id= 'hook_Block_MiddleColumn']");

    public PhotoMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались прогрузки раздела Фото",
                explicitWait( ( ExpectedConditions.visibilityOfAllElements(driver.findElements(MIDDLE_PART_OF_PAGE))),
                        5, 500) );
    }

    public void clickCreateButton() {
        Assert.assertTrue("Не дождались прогрузки раздела Фото",
                explicitWait( ( ExpectedConditions.elementToBeClickable(ALL_ALBUMS)),
                        5, 500) );
        click(CREATE_ALBUM_BUTTON);
    }


    public void typeAlbumName(String albumName) {
        type(albumName, By.id("field_photoAlbumName"));
}

    public void clickCreateAlbum() {
        Assert.assertTrue("Не найден элемент создания альбома", isElementPresent(CREATE_NEW_ALBUM));
        click(CREATE_NEW_ALBUM);
    }

    public boolean isCreationAlbum(String name) {
        final By ALBUM_PRESENT = By.xpath(".//*[text() = '" + name + "' ]");
        return isElementPresent(ALBUM_PRESENT);
    }

    public List<AlbumWrapper> getAllAlbums() {
        if (isElementPresent(ALL_ALBUMS)) {
            return AlbumTransformer.wrap(driver.findElements(ALL_ALBUMS), driver);
        }
        return Collections.emptyList();
    }

    public AlbumWrapper findAlbumByName(List<AlbumWrapper> albums, String albumName) {
            for (AlbumWrapper album : albums) {
                if (album.getAlbumName().equals(albumName)) {
                    return album;
                }
            }
        return null;
    }

    public AlbumPage clickOnAlbum(AlbumWrapper albumWrapper) {
        albumWrapper.clickAlbum();
        return new AlbumPage(driver);
    }

    public PhotoLoadPage addPhoto(String pathName) {
        driver.findElement(PHOTO_ADD_BUTTON).sendKeys(pathName);
        return new PhotoLoadPage(driver);
    }

    public PhotoPage openPhotoById(String photoId){
        By PHOTO = By.xpath(".//*[contains(@id, '" + photoId + "')]");
        Assert.assertTrue("Не найдено фото", isElementPresent(PHOTO));
        click(PHOTO);
        return new PhotoPage(driver);
    }
    public UserMainPage openUserMainPage(){
        Assert.assertTrue("Нет найдена кнопка  \"Одноклассники\"", isElementPresent(USER_MAIN_PAGE));
        click(USER_MAIN_PAGE);
        return new UserMainPage(driver);
    }
    public boolean isPhotoPresent(String photoId){
        By PHOTO = By.xpath(".//*[contains(@id, '" + photoId + "')]");
        return isElementPresent(PHOTO);

    }
}
