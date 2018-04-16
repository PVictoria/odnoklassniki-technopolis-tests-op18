package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhotoMainPage extends HelperBase{

   // private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@href,'st.layer.cmd=PopLayerCreateAltGroup')]");
   private static final By CREATE_NEW_ALBUM = By.xpath(".//*[contains(@class, 'portlet_h_ac' )]");
    public static final By OPEN_PHOTO = By.xpath(".//*[contains(@id, 'img_866966263525')]");
    public static final By OPEN_PHOTO_FOR_LIKE = By.xpath(".//*[contains(@id, 'img_866106130788')]");
    public static final By OPEN_PHOTO_FOR_COM = By.xpath(".//*[contains(@id, 'img_865777208163')]");
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
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_NEW_ALBUM));
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

    public void clickOpenPhoto(By openPhotoLocator) {
        Assert.assertTrue("Не найдено фото", isElementPresent(openPhotoLocator));
        click(openPhotoLocator);
    }

    public boolean isCreationAlbum(String name) {
        final By ALBUM_PRESENT = By.xpath(".//*[text() = '" + name + "' ]");
      //  Assert.assertTrue("Альбом не создан", isElementPresent(ALBUM_PRESENT));
        return isElementPresent(ALBUM_PRESENT);
        //должен возвращать boolean
    }

    public void clickOnAlbum(){
       click(By.xpath("(.//div[@class='photo-album_cnt'])[3]")); //плохой локатор, можно применить врарппер

        //враппер
//        List<AlbumWrapper> comments = new PhotoMainPage(driver).getComments();
//        Assert.assertTrue("Комментарии при невыполнении условия", comments.get(0).isSmthgDisplayed());

    }

    public void openAlbum(By openAlbumLocator){
        Assert.assertTrue("Не найден альбом", isElementPresent(openAlbumLocator));
        click(openAlbumLocator);
    }

}