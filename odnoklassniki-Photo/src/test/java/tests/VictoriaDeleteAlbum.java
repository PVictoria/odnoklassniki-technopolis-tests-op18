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
    public void createAlbum() {
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        photoMainPage.clickCreateAlbum();
        photoMainPage.typePhotoName(albumName);
        photoMainPage.clickCreateButton();
        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(albumName));
        userMainPage.clickLogout();
    }

    @Test
    public void deleteingAlbum() throws Exception {

        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        AlbumPage albumPage = photoMainPage.clickOnAlbum(albumName);
        albumPage.clickEdit();
        albumPage.clickDeleteButton();
        albumPage.confirmAlbumDeletion();


        // проверка
        Assert.assertTrue("Альбом не удален или cуществует еще один с таким же именем", photoMainPage.isAlbumExist(albumName));
        userMainPage.clickLogout();
        //возвращаемся к фто пэйджу или нет?
        // photoMainPage  = new ToolBar(driver).openPhotoMainPage();

    }

}
