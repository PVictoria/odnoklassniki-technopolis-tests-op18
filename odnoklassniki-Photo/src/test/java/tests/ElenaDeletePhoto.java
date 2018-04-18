package tests;

import core.*;
import model.TestBot;
import org.junit.Test;

import static java.lang.Thread.sleep;

/**
 * Created by User on 18.04.2018.
 */
public class ElenaDeletePhoto extends TestBase {

    @Test
    public void deletePhoto() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPhotosOnToolbar();

        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickPersonalPhoto();
        AlbumPage albumPage = new AlbumPage(driver);
        albumPage.clickEdit();
        albumPage.clickDelete();
        albumPage.isDeleted();
        sleep(500);
        albumPage.recoveryPhoto();
    }
}
