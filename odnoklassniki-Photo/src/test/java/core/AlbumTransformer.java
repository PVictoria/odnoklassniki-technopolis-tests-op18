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

            List<AlbumWrapper> albums = new ArrayList<AlbumWrapper>();
            for (WebElement album : elements) {
                albums.add(new AlbumWrapper(album, driver));
            }
            return albums;
        }


//    public AlbumWrapper findAlbumByName(List<AlbumWrapper> albums, String albumName) {
//        for (AlbumWrapper album : albums) {
//            if (album.getAlbumName().equals(albumName)) {
//                return album;
//            }
//        }
//        return null;
//    }




}
