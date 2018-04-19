package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EditAlbumPage  extends HelperBase  {

    private static final By EDIT_ALBUM = By.xpath(".//*[text() = 'Редактировать, изменить порядок']"); //Lena
    private static final By DELETE_BUTTON = By.xpath(".//*[@id='hook_Block_PhotoCardV2Block867039499749']//child::*[@class = 'photo-widget __del']"); //Lena
    private static final By DELETE_DONE = By.xpath(".//*[@class = 'photo_delete va_target']"); //Lena
    private static final By RECOVERY_PHOTO = By.xpath(".//*[text() = 'Восстановить']"); //Lena

    public static final String newAlbumName = "NewName";

    public static final By FIND_ALBUM_NAME = By.xpath(".//*[contains(@class,'it_w')]//*[@data-module='PhotoEdit']");
    public static final By RETERN_TO_PHOTO_FROM_EDIT = By.xpath("//*[contains(@class,'tico_img ic12')]//parent::span[@class='tico tico__12']//parent::*[@class='al']");
    public static final By EDIT_ALBUM_LOCATOR = By.xpath("//*[contains(@class,'tico_img ic12')]/parent::span[@class='tico tico__12']/parent::a");
    public static final By MIDDLE_PART_OF_PAGE = By.xpath(".//*[@id= 'hook_Block_MiddleColumn']");

    public static final By DELETE_ALBUM = By.linkText("Удалить альбом");
    public static final By CONFIRM_DELETE_ALBUM = By.id("hook_FormButton_button_delete_confirm");
    public static final By TARGET_ALBUM = By.xpath("((.//*[contains(@class,'drop-lst')])/descendant::li[contains(@class, 'custom-isl')])");
    public static final By DROP_DOWN_LIST_ALBUMS = By.xpath("(.//a[contains(@class,'custom-isl_choice')])");
    public static final By FIRST_PHOTO_IN_ALBUM = By.xpath("(.//span[contains(@class,'selectable-card')])[1]");// плохой локатор, тут тоже можно ваппер
    public static final By MOVE_BUTTON = By.xpath("(.//a[contains(@class,'button_move') ])");
    public static final By INFO_PHOTO_MOVED = By.xpath(".//div[starts-with(@class, 'iblock') ]");

    public  EditAlbumPage(WebDriver driver){
        super(driver);
    }
    public void check(){
        //
    }

    public void clickOnPhoto(){
        click(FIRST_PHOTO_IN_ALBUM);
    }

    public WebElement choseAlbumFromList (List<WebElement> albumList, String albumName){
        for (WebElement webElement : albumList) {
            if ( webElement.getText().equals(albumName)){
                return webElement;
            }
        }
        Assert.assertNotNull("Альбом " + albumName + " не найден", null);
        return null;
    }
    public void choseTargetAlbum(String albumName){
        click(DROP_DOWN_LIST_ALBUMS);
        List<WebElement> albumList = driver.findElements(TARGET_ALBUM);
        WebElement album = choseAlbumFromList(albumList, albumName);
        album.click();
    }
    public void clickMoveButton() {
        click(MOVE_BUTTON);
    }


    public boolean isPhotoMoved(String albumName){
        if ( isElementPresent(INFO_PHOTO_MOVED)) {
            WebElement info = driver.findElement(INFO_PHOTO_MOVED);
            //   if (info.getText().equals("Фото перенесены в альбом\""+albumName+"\"")){
            if (info.getText().contains("Фото перенесены в")){
                return true;
            }
        }
        return false;
    }


    public  void clickDeleteButton (){
        click(DELETE_ALBUM);

    }
    public void confirmAlbumDeletion(){
        click(CONFIRM_DELETE_ALBUM);
    }

    public boolean isChangeAlbumsName(String name){
        final By NAME_CHANGED = By.xpath(".//*[text() = '" + name + "' ]");
        return isElementPresent(NAME_CHANGED);

    }

    public void clickDelete(){ //Lena
        Assert.assertTrue("Не найдено удалить", isElementPresent(DELETE_BUTTON));
        driver.findElement(DELETE_BUTTON).click();
    }
    public void isDeleted(){ //Lena
        Assert.assertTrue("Не найдено фоторафия удалена", isElementPresent(DELETE_DONE));
        driver.findElement(DELETE_DONE);
    }
    public void recoveryPhoto() { //Lena
        Assert.assertTrue("Не найдено востановить", isElementPresent(RECOVERY_PHOTO));
        driver.findElement(RECOVERY_PHOTO).click();
    }

    public void editAlbumName(){
        click(FIND_ALBUM_NAME);
        type(newAlbumName,FIND_ALBUM_NAME);

    }
}
