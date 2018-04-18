package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VictoriaDeleteAlbum extends TestBase {

    //тест-кейс 6  Виктория
    // Удаление албома
    //У бота должен быть хотя бы один альбом помимо личных фотографий
    String albumName = "PA";
    @Before
    public void createAlbum() {
        new LoginMainPage(driver).doLogin(new TestBot("pvikka@mail.ru", "123654v"));
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickCreateAlbum();
        photoMainPage.typePhotoName(albumName);
        photoMainPage.clickCreateButton();
        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(albumName));
        userMainPage.clickLogout();
    }

    @Test

    public void deleteingAlbum() throws Exception {

        new LoginMainPage(driver).doLogin(new TestBot("pvikka@mail.ru", "123654v"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);

        AlbumPage albumPage = photoMainPage.clickOnAlbum(albumName);
         //new AlbumPage(driver);
        albumPage.clickEditButton();
        albumPage.clickDeleteButton();
        albumPage.confirmAlbumDeletion();
        // проверка
        // Assert.assertTrue("Альбом не удален или чуществует еще один с таким же именем", photoMainPage.isAlbumExist(albumName));


    }

}
