package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 18.04.2018.
 */
public class PhotoTransformer { //Lena

    public static List<PhotoWrapper> wrap(List<WebElement> elements, WebDriver driver) {
        if (elements.isEmpty()) {
            return Collections.<PhotoWrapper>emptyList();
        }

        List<PhotoWrapper> photos = new ArrayList<PhotoWrapper>();
        for (WebElement photo : elements) {
            photos.add(new PhotoWrapper(photo, driver));
        }
        return photos;
    }

}
