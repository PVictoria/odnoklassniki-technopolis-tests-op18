package tests;

import core.PhotoMainPage;
import core.LoginMainPage;
import core.TestBase;
import core.UserMainPage;
import model.TestBot;
import org.junit.Test;

public class SecondTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("pvikka@mail.ru", "123654v"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickCreateAlbum();
        photoMainPage.typePhotoName("PhotoAlbum!!!");
        photoMainPage.clickCreateButton();


        //todo не хватает проверки
    }
}