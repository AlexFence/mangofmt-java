package rocks.pizzaandcoffee.mangofmt;

public class MangoFile implements AutoCloseable {
    private long pointer;

    MangoFile() {
        this.pointer = LibMango.new_mango_file();
    }

    public void free() {
        LibMango.mangofile_free(this.pointer);
    }

    public void save(String path) {
        LibMango.mangofile_save(this.pointer, path);
    }

    public int addImageByPath(String path) {
        return LibMango.mangofile_add_image_by_path(this.pointer, path);
    }

    public int imageCount() {
        return LibMango.mangofile_image_count(this.pointer);
    }

    @Override
    public void close() throws Exception {
        this.free();
    }
}
