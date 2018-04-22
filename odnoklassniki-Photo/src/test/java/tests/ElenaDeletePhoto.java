package tests;

import core.*;
import model.TestBot;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by User on 18.04.2018.
 */
public class ElenaDeletePhoto extends TestBase {

    String pathname = "C:/Users/User/Desktop/УНИВЕР/Тестирование/bo.jpg";
    TestBot testBot = new TestBot("QA18testbot9 ", "QA18testbot");
    String idPhoto;
    String albumName = "Личные фото";
    @Before
    public void beforeDelPhoto(){
        idPhoto = HelperTest.loadPhoto(driver, testBot, pathname);
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

        AlbumPage albumPage = photoMainPage.clickOnAlbum(albumName);
        EditAlbumPage editAlbumPage = albumPage.clickEdit();
        editAlbumPage.clickDelete(idPhoto);
        editAlbumPage.isDeleted();
    }
}
