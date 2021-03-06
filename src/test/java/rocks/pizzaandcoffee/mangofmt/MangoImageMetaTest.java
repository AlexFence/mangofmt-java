package rocks.pizzaandcoffee.mangofmt;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.FileNotFoundException;

public class MangoImageMetaTest {

    private MangoImage getImage() throws FileNotFoundException {
        return new MangoImage("/home/fence/Pictures/sample.png");
    }

    @Test
    public void getMime() {
        try {
            MangoImage img = this.getImage();
            MangoImageMeta meta = img.getMetaData();
            String mime = meta.getMime();
            System.out.println(mime);
            assertEquals(mime, "PNG");
        } catch (FileNotFoundException e) {
            assertTrue(false);
        }
    }

}
