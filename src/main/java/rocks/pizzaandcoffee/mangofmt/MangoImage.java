package rocks.pizzaandcoffee.mangofmt;

import com.sun.jna.ptr.IntByReference;
import java.io.FileNotFoundException;
import java.util.Base64;

public class MangoImage {
    IntByReference pointer;

    MangoImage(IntByReference pointer) {
        this.pointer = pointer;
    }

    MangoImage(String path) throws FileNotFoundException {
        IntByReference error = new IntByReference(0);
        IntByReference pointer = LibMango.INSTANCE.mangoimg_from_path(path, error);
        System.out.println(error.getValue());

        if (error.getValue() != 0) {
            throw new FileNotFoundException(path);
        }
        
        this.pointer = pointer;
    }

    void free() {
        LibMango.INSTANCE.mangoimg_free(this.pointer);
    }


    public byte[] getImageData() {
        String base64 = LibMango.INSTANCE.mangoimg_get_base64_image_data(this.pointer);
        return Base64.getDecoder().decode(base64);

    }

    public MangoImageMeta getMetaData() {
        IntByReference ptr = LibMango.INSTANCE.mangoimg_get_meta(this.pointer);
        return new MangoImageMeta(ptr);
    }
}
