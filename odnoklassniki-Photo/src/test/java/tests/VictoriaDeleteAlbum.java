package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Thread.sleep;

public class VictoriaDeleteAlbum extends TestBase {

    //тест-кейс 6  Виктория
    // Удаление албома
    //У бота должен быть хотя бы один альбом помимо личных фотографий
    String albumName = "NewName";
    TestBot testBot = new TestBot("pvikka@mail.ru", "123654v");

    @Before
    public void prepareForDeletingAlbum(){
        HelperTest.createAlbum(driver, testBot, albumName);

    }


//    public void createAlbum() {
//        new LoginMainPage(driver).doLogin(testBot);
//        UserMainPage userMainPage = new UserMainPage(driver);
//        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
//        photoMainPage.clickCreateAlbum();
//        photoMainPage.typeAlbumName(albumName);
//        photoMainPage.clickCreateButton();
//        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(albumName));
//        userMainPage.clickLogout();
//    }

    @Test
    public void deleteingAlbum() throws Exception {

        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        AlbumPage albumPage = photoMainPage.clickOnAlbum(albumName);
        EditAlbumPage editAlbumPage = albumPage.clickEdit();
        editAlbumPage.clickDeleteButton();
        editAlbumPage.confirmAlbumDeletion();
        photoMainPage  = new ToolBar(driver).openPhotoMainPage();
        Assert.assertTrue("Альбом не удален или cуществует еще один с таким же именем", photoMainPage.isAlbumExist(albumName));
        userMainPage.clickLogout();


    }

}
