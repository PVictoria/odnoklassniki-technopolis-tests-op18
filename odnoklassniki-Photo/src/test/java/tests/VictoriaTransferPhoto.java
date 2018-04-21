package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VictoriaTransferPhoto extends TestBase{
    String albumNameFrom = "From";
    String albumNameTo = "Target";
    TestBot testBot = new TestBot("pvikka@mail.ru", "123654v");
    //тест-кейс 8  Виктория
    //У бота должно быть создано 2 альбома помимо личных фотографий.
    // Хотя бы в одном альбоме должна быть хотя бы одна фотография
//    @Before
//    public void createAlbums() {
//
//        new LoginMainPage(driver).doLogin(testBot);
//        UserMainPage userMainPage = new UserMainPage(driver);
//        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
//
//        photoMainPage.clickCreateAlbum();
//        photoMainPage.typeAlbumName(albumNameFrom);
//        photoMainPage.clickCreateButton();
//        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(albumNameFrom));
//        //нажимаем добавить фото
//        //
////Toolbar - photo и еще один альбом
//
//        userMainPage.clickLogout();
//    }
//    @Before
//    public void loadPhoto() {
//        new LoginMainPage(driver).doLogin(testBot);
//        UserMainPage userMainPage = new UserMainPage(driver);
//        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
//
//        //driver.findElement(By.xpath(".//*[contains(@class, 'photo-stream')]//*[contains(@class, 'add-stub') and text()='Добавить фото']")).click();
//        //тут ваш путь до файла
//        String pathname = "C:/JavaProjects/myPhoto.jpg";
//        photoMainPage.addPhoto(pathname);
//        //проверка, что фото добавлено
//    }


    @Before
    public void prepareFroTransferPhoto(){

    }
    @Test
    public void transferPhotosFromAlbumToAlbum() throws Exception {

        new LoginMainPage(driver).doLogin(new TestBot("pvikka@mail.ru", "123654v"));
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();


        //Поиск альбома по имени изменен в соответствии с пожеланиями Эмилии
        List<AlbumWrapper> albums = photoMainPage.getAllAlbums();
        AlbumWrapper albumFrom = photoMainPage.findAlbumByName(albums, albumNameFrom);
        Assert.assertNotNull("Альбом " + albumNameFrom + " не найден", albumFrom);
        //метод clickOnAlbum(album) теперь принимает AlbumWrapper в качестве аргумента
        AlbumPage albumPage = photoMainPage.clickOnAlbum(albumFrom);

        //AlbumPage albumPage = new AlbumPage(driver);
        EditAlbumPage editAlbumPage = albumPage.clickEdit();
        editAlbumPage.clickOnPhoto();

        //editAlbumPage.choseTargetAlbum(albumNameTo);
        editAlbumPage.clickDropdownAlbumList();
        List<WebElement> albumList = editAlbumPage.listAllTargetAlbums();
        WebElement albumTo = editAlbumPage.choseAlbumFromList(albumList, albumNameTo);
        albumTo.click();
        editAlbumPage.clickMoveButton();
        Assert.assertTrue("Фото не перенесены", editAlbumPage.isPhotoMoved(albumNameTo)); //проверить сам текст


        //проверка по айди фоотографии
        // проверка

        userMainPage.clickLogout();


    }
}
