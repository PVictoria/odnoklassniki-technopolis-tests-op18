package tests;

import core.*;
import model.TestBot;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Thread.sleep;

/**
 * Created by User on 18.04.2018.
 */
public class ElenaDeletePhoto extends TestBase {

    String pathname = "C:/Users/User/Desktop/bo.jpg";
    TestBot testBot = new TestBot("QA18testbot9 ", "QA18testbot");
    String id;
    @Before
    public void beforeDelPhoto(){
        id = HelperTest.loadPhoto(driver, testBot, pathname);
        /*new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        String pathname = "C:/Users/User/Desktop/bo.jpg";
        id = photoMainPage.addPhoto(pathname);
        userMainPage.clickLogout();*/

    }
    @Test
    public void deletePhoto() throws Exception{
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();

        photoMainPage.clickPersonalPhoto();
        AlbumPage albumPage = new AlbumPage(driver);
        EditAlbumPage editAlbumPage = albumPage.clickEdit();
        editAlbumPage.clickDelete(id);
        editAlbumPage.isDeleted();
    }
}
