package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlbumTransformer {


        public static List<AlbumWrapper> wrap(List<WebElement> elements, WebDriver driver) {
            if (elements.isEmpty()) {
                return Collections.<AlbumWrapper>emptyList();
            }
            List<AlbumWrapper> comments = new ArrayList<AlbumWrapper>();
            for (WebElement comment : elements) {
                comments.add(new AlbumWrapper(comment, driver));
            }
            return comments;
        }


}
