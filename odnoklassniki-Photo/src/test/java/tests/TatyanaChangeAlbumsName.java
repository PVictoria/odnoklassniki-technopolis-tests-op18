package tests;

import core.*;
import model.TestBot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static core.AlbumPage.newAlbumName;
import static core.PhotoMainPage.OPEN_ALBUM;

/**
 * Created by таня on 18.04.2018.
 */
public class TatyanaChangeAlbumsName extends TestBase{
    TestBot testBot = new TestBot("QA18testbot20 ", "QA18testbot1");
    String oldAlbumName = "Old Album!";

    @Before
    public void beforeChangeAlbumsName(){
        HelperTest.createAlbum(driver, testBot, oldAlbumName);
    }
    /*public void createAlbum() {
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot20", "QA18testbot1"));
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.clickCreateAlbum();
        photoMainPage.typeAlbumName(oldAlbumName);
        photoMainPage.clickCreateButton();
        Assert.assertTrue("Альбом не создан", photoMainPage.isCreationAlbum(oldAlbumName));
        userMainPage.clickLogout();

    }*/
    @Test
    public void changeAlbumsName() throws Exception{
        new LoginMainPage(driver).doLogin(testBot);
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        List<AlbumWrapper> albums = new PhotoMainPage(driver).getAllAlbums();
        AlbumWrapper album = photoMainPage.findAlbumByName(albums, oldAlbumName);
        Assert.assertNotNull("Альбом " + oldAlbumName + " не найден", album);
        AlbumPage albumPage = photoMainPage.clickOnAlbum(album);
        EditAlbumPage editAlbumPage = albumPage.clickEdit();
        editAlbumPage.editAlbumName();
        Assert.assertTrue("Имя альбома не изменено", editAlbumPage.isChangeAlbumsName(newAlbumName));
        //photoMainPage  = new ToolBar(driver).openPhotoMainPage();
        userMainPage.clickLogout();
    }

    @After
    public void afterChangeAlbumsName() throws Exception{

    }
}
