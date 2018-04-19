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
}
