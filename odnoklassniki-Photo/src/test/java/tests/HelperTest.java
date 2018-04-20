package tests;

import core.HelperBase;
import core.LoginMainPage;
import core.PhotoMainPage;
import core.UserMainPage;
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
     static void createAlbum(WebDriver driver, TestBot testBot, String albumName) {
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        photoMainPage.clickCreateAlbum();
        photoMainPage.typeAlbumName(albumName);
        photoMainPage.clickCreateButton();
        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(albumName));
        userMainPage.clickLogout();
    }

    static void loadPhoto(WebDriver driver, TestBot testBot, String pathName, String photoId) {
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();

        photoId = photoMainPage.addPhoto(pathName);
        //проверка, что фото добавлено
        userMainPage.clickLogout();
    }

}
