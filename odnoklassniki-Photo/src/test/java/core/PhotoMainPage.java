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

    // private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@href,'st.layer.cmd=PopLayerCreateAltGroup')]");
    private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@class, 'portlet_h_ac' )]");
    public static final By OPEN_PHOTO = By.xpath(".//*[contains(@id, 'img_866966263525')]");  //Lena
    //private static final String idPhoto = "img_866966263525";

    public static final By OPEN_PHOTO_FOR_LIKE = By.xpath(".//*[contains(@id, 'img_866106130788')]");
    public static final By OPEN_PHOTO_FOR_COM = By.xpath(".//*[contains(@id, 'img_865777208163')]");
    private static final By PERSONAL_PHOTO = By.xpath(".//*[@title = 'Личные фото']");


    public static final By OPEN_ALBOM = By.xpath(".//*[contains(@id,'hook_Block_PhotoCardBlock')]//*[@class='photo-album_cnt']");

    public static final By ALL_ALBUMS = By.xpath(".//*[contains(@id, 'UserAlbumStreamBlockLoader')]/descendant::li[@class = 'ugrid_i']");

    public static final By OPEN_ALBUM = By.xpath(".//*[contains(@id,'hook_Block_PhotoCardBlock')]//*[@class='photo-album_cnt']");
    private static final By PHOTO_ADD_BUTTON = By.xpath(".//*[contains(@class, 'photo-stream')]//*[contains(@class, 'add-stub') and text()='Добавить фото']");
            //By.xpath(".//input[@type = 'file' and @name = 'photo']");


    public PhotoMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
//        //пример использования метода из HelperBase
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return isElementPresent(CREATE_NEW_ALBUM);
//            }
//        });

        //пример использования класса ExpectedConditions
        //  (new WebDriverWait(driver, 10))
        //.until(ExpectedConditions.visibilityOfElementLocated(OPEN_PHOTO));
        //.until(ExpectedConditions.visibilityOfElementLocated(OPEN_PHOTO_FOR_COM));
        //   .until(ExpectedConditions.visibilityOfElementLocated(OPEN_PHOTO_FOR_LIKE));


        Assert.assertTrue("Не дождались прогрузки раздела Фото",
                explicitWait( ( ExpectedConditions.visibilityOfAllElements(driver.findElements(ALL_ALBUMS))),
                        5, 500) );
    }

    public void clickCreateButton() {
        //click(By.id("hook_FormButton_button_create"));
        click(By.id("hook_FormButton_button_album_create"));
    }


    public void typeAlbumName(String albumName) {
        type(albumName, By.id("field_photoAlbumName"));
    }

    public void clickCreateAlbum() {
        Assert.assertTrue("Не найден элемент создания альбома", isElementPresent(CREATE_NEW_ALBUM));
        driver.findElement(CREATE_NEW_ALBUM).click();
    }

    public void clickOpenPhotoLena() {  //Lena
        Assert.assertTrue("Не найдено фото", isElementPresent(OPEN_PHOTO));
        driver.findElement(OPEN_PHOTO).click();
    }

    public void clickOpenPhotoForCom() {
        Assert.assertTrue("Не найдено фото", isElementPresent(OPEN_PHOTO_FOR_COM));
        click(OPEN_PHOTO_FOR_COM);
    }

    public void clickOpenPhotoForLike() {
        Assert.assertTrue("Не найдено фото", isElementPresent(OPEN_PHOTO_FOR_LIKE));
        click(OPEN_PHOTO_FOR_LIKE);
    }

    public boolean isCreationAlbum(String name) {
        final By ALBUM_PRESENT = By.xpath(".//*[text() = '" + name + "' ]");
        //  Assert.assertTrue("Альбом не создан", isElementPresent(ALBUM_PRESENT));
        return isElementPresent(ALBUM_PRESENT);
        //должен возвращать boolean
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
        Assert.assertNotNull("Альбом " + albumName + " не найден", null);
        return null;
    }

    public AlbumPage clickOnAlbum(String albumName) {
        //враппер
        List<AlbumWrapper> albums = new PhotoMainPage(driver).getAllAlbums();
        AlbumWrapper album = findAlbumByName(albums, albumName);
        Assert.assertTrue("Альбом " + albumName + " не найден", album.isExist());
        album.clickAlbum();
        return new AlbumPage(driver);
    }

    public void clickPersonalPhoto() {  //Lena
        Assert.assertTrue("Не найдены личные фотографии", isElementPresent(PERSONAL_PHOTO));
        driver.findElement(PERSONAL_PHOTO).click();
    }

    public void openAlbum(By openAlbumLocator) {
        Assert.assertTrue("Не найден альбом", isElementPresent(openAlbumLocator));
        click(openAlbumLocator);
    }

    public boolean isAlbumExist(String albumName) {
        //делать этот метод тут или на другом пэйдже???
        return false;
    }

    public void addPhoto(String pathname) {
        driver.findElement(PHOTO_ADD_BUTTON).sendKeys(pathname);
    }
}