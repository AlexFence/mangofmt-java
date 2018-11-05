package rocks.pizzaandcoffee.mangofmt;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MangoFileTest {

    boolean fileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    @Test
    void create() {
        try {
            MangoFile file = new MangoFile();
            file.free();
        } catch(Exception e) {
            fail("oh no");
        }
    }

    @Test
    void save() {
        MangoFile file = new MangoFile();
        file.save("/tmp/test.mango");
        assert this.fileExists("/tmp/test.mango");
        file.free();
    }

    @Test
    void addImage() {
        MangoFile file = new MangoFile();
        assertEquals(0, file.imageCount());
        int error = file.addImageByPath("~/Pictures/sample.png");
        assertEquals(0, error);
        assertEquals(1, file.imageCount());
    }
}