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
        } catch(Exception e) {
            fail("oh no");
        }
    }

    @Test
    void save() {
        MangoFile file = new MangoFile();
        file.save("/tmp/test.mango");
        assert this.fileExists("/tmp/test.mango");

    }
}