package tests;

import core.*;
import model.TestBot;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

/**
 * Created by User on 18.04.2018.
 */

import org.junit.Assert;

public class ElenaAddDescription extends TestBase{

    String description = "Описание...";

    @Test
    public void addDescription() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("QA18testbot9 ", "QA18testbot"));
      //  new UserMainPage(driver).clickPhotosOnToolbar();
        UserMainPage userMainPage = new UserMainPage(driver);
        PhotoMainPage photoMainPage = userMainPage.clickPhotosOnToolbar();
        PhotoPage photoPage = photoMainPage.clickOpenPhotoLena();

        DescInterface photoInterface = new DescFactory().getPage(driver);
        //Assert.assertTrue("Комментарии при невыполнении условия", photoInterface.isDescEmpty()); //??
        photoInterface.clickAddDescription();
        photoInterface.typeDescrName(description);
        photoInterface.clickSaveDescription();

        Assert.assertTrue( "Описание не добавлено", photoPage.isAddDescription(description));
        photoPage.closePhoto();
        userMainPage.clickLogout();
    }
}
