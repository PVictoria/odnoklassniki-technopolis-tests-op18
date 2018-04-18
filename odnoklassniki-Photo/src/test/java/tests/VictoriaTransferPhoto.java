package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

public class VictoriaTransferPhoto extends TestBase{

    //тест-кейс 8  Виктория
    //У бота должно быть создано 2 альбома помимо личных фотографий.
    // Хотя бы в одном альбоме должна быть хотя бы одна фотография
    @Test
    public void transferPhotosFromAlbumToAlbum() throws Exception {

        new LoginMainPage(driver).doLogin(new TestBot("pvikka@mail.ru", "123654v"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        String albumNameFrom = "Old";
        AlbumPage albumPage = photoMainPage.clickOnAlbum(albumNameFrom); //должен возвращать albumPage
        //AlbumPage albumPage = new AlbumPage(driver);
        albumPage.clickEdit();
        albumPage.clickOnPhoto();
        String albumNameTo = "Личные фото";
        albumPage.choseTargetAlbum(albumNameTo);
        albumPage.clickMoveButton();
        Assert.assertTrue("Фото не перенесены", albumPage.isPhotoMoved()); //проверить сам текст
        //проверка по айди фоотографии
        // проверка


    }
}
