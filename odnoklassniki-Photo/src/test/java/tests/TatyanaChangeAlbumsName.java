package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static core.AlbumPage.newAlbumName;
import static core.PhotoMainPage.OPEN_ALBUM;

/**
 * Created by таня on 18.04.2018.
 */
public class TatyanaChangeAlbumsName extends TestBase{
    //тест-кейсизменение названия альбома
    //в before создание альбома??
    String oldAlbumName = "Old Album5";
    @Before
    public void createAlbum() {
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot20", "QA18testbot1"));
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickCreateAlbum();
        photoMainPage.typePhotoName(oldAlbumName);
        photoMainPage.clickCreateButton();
        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(oldAlbumName));
        userMainPage.clickLogout();
    }
    @Test
    public void changeAlbumsName() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot20", "QA18testbot1"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.openAlbum(OPEN_ALBUM);
        //photoMainPage.clickOnAlbum(oldAlbumName);
        AlbumPage albumPage = new AlbumPage(driver);
        albumPage.clickEditAlbum();
        albumPage.editAlbumName();
        albumPage.returnToPhoto();
        //проверка
        Assert.assertTrue("Имя альбома не изменено", albumPage.isChangeAlbumsName(newAlbumName));
    }
}
