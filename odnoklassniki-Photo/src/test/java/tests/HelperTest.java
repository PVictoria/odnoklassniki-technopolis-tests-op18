package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HelperTest {
    private HelperTest(){

    }
/**
 * Методы для подготовки ботов (Before)
 * Выполнения действий, проверяется только ассертами (нет глобальных проверок
 * тк они должны быть в других тестах)
 */
     public static void createAlbum(WebDriver driver, TestBot testBot, String albumName) {
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        photoMainPage.clickCreateAlbum();
        photoMainPage.typeAlbumName(albumName);
        photoMainPage.clickCreateButton();
        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(albumName));
        userMainPage.clickLogout();
     }

    public static String loadPhoto(WebDriver driver, TestBot testBot, String pathName) {
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        String photoId = photoMainPage.addPhoto(pathName);
        //проверка, что фото добавлено не нужна тк это метод before, а не теста
        userMainPage.clickLogout();
        return photoId;
    }

    public static void deletePhoto(WebDriver driver, TestBot testBot, String photoId){
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        PhotoPage photoPage = photoMainPage.openPhotoById(photoId);
        photoPage.deletePhoto();
        photoPage.closePhoto();
        Assert.assertTrue("Фото не удалено", photoMainPage.isPhotoPresent(photoId));

//        photoMainPage.clickPersonalPhoto();
//        AlbumPage albumPage = new AlbumPage(driver);
//        EditAlbumPage editAlbumPage = albumPage.clickEdit();
//        editAlbumPage.clickDelete(id);
//        editAlbumPage.isDeleted();
    }
}
