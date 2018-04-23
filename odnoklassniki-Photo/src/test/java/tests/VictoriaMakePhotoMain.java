package tests;

import core.*;
import model.TestBot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static tests.HelperTest.deletePhoto;

public class VictoriaMakePhotoMain extends TestBase {

    TestBot testBot = new TestBot("QA18testbot57 ", "QA18testbot");
    String albumName = "Личные фото";
    String pathName = "C:/JavaProjects/myPhoto.jpg";
            //"C:/Users/User/Desktop/УНИВЕР/Тестирование/bo.jpg";
    String photoId;



    @Before
    public void prepareForMakePhotoMain(){
        photoId = HelperTest.loadPhoto(driver, testBot, pathName);
    }

    @Test
    public void makePhotoMain() {

        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        //Поиск альбома по имени изменен в соответствии с пожеланиями Эмилии
        List<AlbumWrapper> albums = new PhotoMainPage(driver).getAllAlbums();
        AlbumWrapper album = photoMainPage.findAlbumByName(albums, albumName);
        Assert.assertNotNull("Альбом " + albumName + " не найден", album);
        //метод clickOnAlbum(album) теперь принимает AlbumWrapper в качестве аргумента
        AlbumPage albumPage = photoMainPage.clickOnAlbum(album);
        PhotoPage photoPage = albumPage.openPhotoById(photoId); //внутри эдита
        photoPage.makePhotoMain();
        photoPage.closePhotoRetPhotoMainP();
        photoMainPage.openUserMainPage();
        String mainPhotoId = userMainPage.getMainPhoto();
        Assert.assertFalse("Фото не утановлено", photoId.equals(mainPhotoId));
        userMainPage.clickLogout();


    }
    @After
    public void deleteLoadedPhotos(){
        HelperTest.deletePhoto(driver, testBot, photoId);
    }

}
