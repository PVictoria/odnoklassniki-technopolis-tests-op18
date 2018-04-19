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
    String oldAlbumName = "Old Album!";
    @Before
    public void createAlbum() {
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot20", "QA18testbot1"));
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickCreateAlbum();
        photoMainPage.typeAlbumName(oldAlbumName);
        photoMainPage.clickCreateButton();
        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(oldAlbumName));
        userMainPage.clickLogout();
    }
    @Test
    public void changeAlbumsName() throws Exception{
//        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot20", "QA18testbot1"));
//        new UserMainPage(driver).clickPhotosOnToolbar();
//        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
//        photoMainPage.openAlbum(OPEN_ALBUM);
//
//        AlbumPage albumPage = new AlbumPage(driver);
//        albumPage.clickEditAlbum(); //эти методы теперь в EditAlbumPage
//        albumPage.editAlbumName();
//        albumPage.returnToPhoto(); //  photoMainPage  = new ToolBar(driver).openPhotoMainPage();
//        //проверка
//        Assert.assertTrue("Имя альбома не изменено", albumPage.isChangeAlbumsName(newAlbumName));

        //При открытии нового пейджа методдолжен его возвращать
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot20", "QA18testbot1"));
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();

        AlbumPage albumPage = photoMainPage.clickOnAlbum(oldAlbumName);

        EditAlbumPage editAlbumPage = albumPage.clickEdit(); //эти методы теперь в EditAlbumPage
        editAlbumPage.editAlbumName();
        Assert.assertTrue("Имя альбома не изменено", editAlbumPage.isChangeAlbumsName(newAlbumName));
        photoMainPage  = new ToolBar(driver).openPhotoMainPage();
        //проверка


    }
}
