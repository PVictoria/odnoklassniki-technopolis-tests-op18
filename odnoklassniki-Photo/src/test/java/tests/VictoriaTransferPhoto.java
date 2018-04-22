package tests;

import core.*;
import model.TestBot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VictoriaTransferPhoto extends TestBase{
    TestBot testBot = new TestBot("pvikka@mail.ru", "123654v");
    String albumNameFrom = "Личные фото";
    String albumNameTo = "Target";
    String pathName = "C:/JavaProjects/myPhoto.jpg";
    String photoId;

    @Before
    /**
     *  Альбом Target должен быть создан
     */

    public void prepareFroTransferPhoto(){
        photoId = HelperTest.loadPhoto(driver,testBot,pathName);


    }
    @Test
    public void transferPhotosFromAlbumToAlbum() throws Exception {

        new LoginMainPage(driver).doLogin(new TestBot("pvikka@mail.ru", "123654v"));
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();

        List<AlbumWrapper> albums = photoMainPage.getAllAlbums();
        AlbumWrapper albumFrom = photoMainPage.findAlbumByName(albums, albumNameFrom);
        Assert.assertNotNull("Альбом " + albumNameFrom + " не найден", albumFrom);
        AlbumPage albumPage = photoMainPage.clickOnAlbum(albumFrom);
        EditAlbumPage editAlbumPage = albumPage.clickEdit();
        editAlbumPage.clickOnPhoto();
        editAlbumPage.clickDropdownAlbumList();
        List<WebElement> albumList = editAlbumPage.listAllTargetAlbums();
        WebElement albumTo = editAlbumPage.choseAlbumFromList(albumList, albumNameTo);
        Assert.assertNotNull("Альбом " + albumNameTo + " не найден", albumTo);
        albumTo.click();
        editAlbumPage.clickMoveButton();
        Assert.assertTrue("Фото не перенесены", editAlbumPage.isPhotoMoved(albumNameTo));
        /**
         * Проверка наличия фотографий в альбомах  по id
         */
        photoMainPage  = new ToolBar(driver).openPhotoMainPage();
        albums = photoMainPage.getAllAlbums();
        AlbumWrapper fromAlbum = photoMainPage.findAlbumByName(albums, albumNameFrom);
        albumPage = photoMainPage.clickOnAlbum(fromAlbum);
        Assert.assertFalse("Фото не перенесено",albumPage.isPhotoPresent(photoId));
        photoMainPage  = new ToolBar(driver).openPhotoMainPage();
        albums = photoMainPage.getAllAlbums();
        AlbumWrapper targetAlbum = photoMainPage.findAlbumByName(albums, albumNameTo);
        albumPage = photoMainPage.clickOnAlbum(targetAlbum);
        Assert.assertTrue("Фото не перенесено",albumPage.isPhotoPresent(photoId));
        userMainPage.clickLogout();


    }
    @After
    public void deleteAfterTest(){
        HelperTest.deletePhoto(driver,testBot,photoId);
    }
}
