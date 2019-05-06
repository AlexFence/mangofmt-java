package rocks.pizzaandcoffee.mangofmt;

import com.sun.jna.ptr.IntByReference;

public class MangoFile implements AutoCloseable {
    private long pointer;

    MangoFile() {
        this.pointer = LibMango.INSTANCE.mangofile_new();
    }

    MangoFile(long pointer) {
        this.pointer = pointer;
    }

    public static MangoFile open(String path) {
        return new MangoFile(LibMango.INSTANCE.mangofile_open(path, 0));
    }

    public void free() {
        LibMango.INSTANCE.mangofile_free(this.pointer);
    }

    public void save(String path) {
        LibMango.INSTANCE.mangofile_save(this.pointer, path);
    }

    public int addImageByPath(String path) {
        return LibMango.INSTANCE.mangofile_add_image_by_path(this.pointer, path);
    }

    public int getImageCount() {
        return LibMango.INSTANCE.mangofile_get_image_count(this.pointer);
    }

    public MangoImage getImage(int index) {
        IntByReference ptr = LibMango.INSTANCE.mangofile_get_image(this.pointer, index);
        return new MangoImage(ptr);
    }

    @Override
    public void close() throws Exception {
        this.free();
    }
}
