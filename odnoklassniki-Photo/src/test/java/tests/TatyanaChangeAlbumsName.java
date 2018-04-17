package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import static core.AlbumPage.NEW_ALBUM_NAME;
import static core.PhotoMainPage.OPEN_ALBUM;

/**
 * Created by таня on 18.04.2018.
 */
public class TatyanaChangeAlbumsName extends TestBase{
    //тест-кейсизменение названия альбома
    @Test
    public void changeAlbomsName() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot20", "QA18testbot1"));
        new UserMainPage(driver).clickPhotosOnToolbar();
        PhotoMainPage photoMainPage = new PhotoMainPage(driver);
        photoMainPage.openAlbum(OPEN_ALBUM);
        AlbumPage albumPage = new AlbumPage(driver);
        albumPage.clickEditAlbum();
        albumPage.editAlbumName();
        albumPage.returnToPhoto();
        //проверка
        Assert.assertTrue("Имя альбома не изменено", albumPage.isChangeAlbumsName(NEW_ALBUM_NAME));
    }
}
