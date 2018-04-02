package tests;

import core.PhotoMainPage;
import core.LoginMainPage;
import core.TestBase;
import core.UserMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.Thread.sleep;

public class SecondTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("pvikka@mail.ru", "123654v"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickCreateAlbum();
        String pa = "PhotoAlbum!!!";
        photoMainPage.typePhotoName(pa);
        sleep(5000);
        photoMainPage.clickCreateButton();
      //  photoMainPage.isCreationAlbum("PhotoAlbum!!!");
        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(pa));

                //todo не хватает проверки
    }
}