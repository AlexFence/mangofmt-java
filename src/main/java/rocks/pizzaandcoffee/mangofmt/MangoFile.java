package rocks.pizzaandcoffee.mangofmt;

public class MangoFile implements AutoCloseable {
    private long pointer;

    MangoFile() {
        this.pointer = LibMango.INSTANCE.mangofile_new();
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

    public int imageCount() {
        return LibMango.INSTANCE.mangofile_get_image_count(this.pointer);
    }

    @Override
    public void close() throws Exception {
        this.free();
    }
}
