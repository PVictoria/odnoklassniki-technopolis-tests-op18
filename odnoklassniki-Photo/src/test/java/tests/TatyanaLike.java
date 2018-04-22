package tests;

import core.*;
import model.TestBot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static core.PhotoMainPage.OPEN_PHOTO_FOR_LIKE;

/**
 * Created by таня on 18.04.2018.
 */
public class TatyanaLike extends TestBase {
    String pathname = "C:/Users/User/Desktop/УНИВЕР/Тестирование/bo.jpg";
    TestBot testBot = new TestBot("QA18testbot20 ", "QA18testbot1");
    String idPhoto;

    @Before
    public void beforeAddComments() throws Exception{
        idPhoto = HelperTest.loadPhoto(driver, testBot, pathname);
    }

    @Test
    public void likeToMyPhoto() throws Exception {
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        PhotoPage photoPage = photoMainPage.openPhotoById(idPhoto);
        ClickLikePromise clickLikePromise = photoPage.clickLike(driver, photoPage);
        photoPage = clickLikePromise.andClickLikeOn();
        photoPage.closePhoto();
        userMainPage.clickLogout();
    }

    @After
    public void afterAddComments() throws Exception{
        HelperTest.deletePhoto(driver, testBot, idPhoto);
    }
}
