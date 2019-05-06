package rocks.pizzaandcoffee.mangofmt;

import com.sun.jna.ptr.IntByReference;

import java.util.Base64;

public class MangoImage {
    IntByReference pointer;

    MangoImage(IntByReference pointer) {
        this.pointer = pointer;
    }

    void free() {
        LibMango.INSTANCE.mangoimg_free(this.pointer);
    }


    byte[] getImageData() {
        String base64 = LibMango.INSTANCE.mangoimg_get_base64_image_data(this.pointer);
        return Base64.getDecoder().decode(base64);

    }
}
