package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

public class PhotoMainPage extends HelperBase{

   // private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@href,'st.layer.cmd=PopLayerCreateAltGroup')]");
    private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@class, 'portlet_h_ac' )]");
    public static final By OPEN_PHOTO = By.xpath(".//*[contains(@id, 'img_866966263525')]");  //Lena
    //private static final String idPhoto = "img_866966263525";

    public static final By OPEN_PHOTO_FOR_LIKE = By.xpath(".//*[contains(@id, 'img_866106130788')]");
    public static final By OPEN_PHOTO_FOR_COM = By.xpath(".//*[contains(@id, 'img_865777208163')]");
    private static final By PERSONAL_PHOTO = By.xpath(".//*[@title = 'Личные фото']");


    public static final By OPEN_ALBOM = By.xpath(".//*[contains(@id,'hook_Block_PhotoCardBlock')]//*[@class='photo-album_cnt']");
    //public static final By ALL_ALBUMS = By.xpath("(.//div[@class='photo-album_cnt'])");
    public static final By ALL_ALBUMS = By.xpath(".//div[contains(@id, 'UserAlbumStreamBlockLoader')]/descendant::li[@class = 'ugrid_i']");


    public static final By OPEN_ALBUM = By.xpath(".//*[contains(@id,'hook_Block_PhotoCardBlock')]//*[@class='photo-album_cnt']");


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
        (new WebDriverWait(driver, 10))
                //.until(ExpectedConditions.visibilityOfElementLocated(OPEN_PHOTO));
                //.until(ExpectedConditions.visibilityOfElementLocated(OPEN_PHOTO_FOR_COM));
                .until(ExpectedConditions.visibilityOfElementLocated(OPEN_PHOTO_FOR_LIKE));
    }
    
    public void clickCreateButton() {
        //click(By.id("hook_FormButton_button_create"));
        click(By.id("hook_FormButton_button_album_create"));
    }


    public void typePhotoName(String albumName) {
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
    public List<AlbumWrapper> getAllAlbums (){
        if (isElementPresent(ALL_ALBUMS)) {
            return AlbumTransformer.wrap(driver.findElements(ALL_ALBUMS), driver);
        }
        return Collections.emptyList();
    }

    public void clickOnAlbum(String albumName){
      // click(By.xpath("(.//div[@class='photo-album_cnt'])[3]")); //плохой локатор, можно применить врарппер

        //враппер
       List<AlbumWrapper> albums = new PhotoMainPage(driver).getAllAlbums();
      // Assert.assertTrue("Нет альбомов кроме \" Личные фотографии \" ", albums.get(2).isSmthgDisplayed());
       //albums.get(number).clickAlbum();


        // весь фор в отдельный метод поиска альбома по имени
        //клик будет в тесте


        boolean flag = false;
        for (AlbumWrapper album : albums) {
            if ( album.getAlbumName().equals(albumName)){
                album.clickAlbum();
                flag = true;
                break;
            }
        }
        Assert.assertTrue("Альбом " + albumName + " не найден", flag);


    }

    public void clickPersonalPhoto(){  //Lena
        Assert.assertTrue("Не найдены личные фотографии", isElementPresent(PERSONAL_PHOTO));
        driver.findElement(PERSONAL_PHOTO).click();
    }

    public void openAlbum(By openAlbumLocator){
        Assert.assertTrue("Не найден альбом", isElementPresent(openAlbumLocator));
        click(openAlbumLocator);
    }
    public boolean isAlbumExist(String albumName){
        //делать этот метод тут или на другом пэйдже???
        return false;
    }
}