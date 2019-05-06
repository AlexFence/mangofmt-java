package rocks.pizzaandcoffee.mangofmt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MangoImageTest {

    private MangoFile getFile() {
        MangoFile file = new MangoFile();
        assertEquals(0, file.getImageCount());
        int error = file.addImageByPath("/home/fence/Pictures/sample.png");
        assertEquals(0, error);
        assertEquals(1, file.getImageCount());
        return file;
    }

    @Test
    public void getImageData() {
        MangoFile file = this.getFile();
        MangoImage img = file.getImage(0);
        byte[] imgData = img.getImageData();
        assertTrue(imgData.length > 0);
    }


}
