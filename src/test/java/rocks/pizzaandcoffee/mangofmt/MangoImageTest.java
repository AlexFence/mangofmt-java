package rocks.pizzaandcoffee.mangofmt;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.FileNotFoundException;

public class MangoImageTest {

    private MangoImage getImage() throws FileNotFoundException {
        return new MangoImage("/home/fence/Pictures/sample.png");
    }

    @Test
    public void getImageData() {
        try {
            MangoImage img = this.getImage();
            byte[] imgData = img.getImageData();
            assertTrue(imgData.length > 0);
        } catch (FileNotFoundException e) {
            assertTrue(false);
        }
    }

    
    @Test
    public void getImageMetaData() {
        try {
            MangoImage img = this.getImage();
            MangoImageMeta meta = img.getMetaData();
            String checksum = meta.getChecksum();
            System.out.print(checksum);
            assertTrue(checksum.length() == 64);
        } catch (FileNotFoundException e) {
            assertTrue(false);
        }
    }

}
