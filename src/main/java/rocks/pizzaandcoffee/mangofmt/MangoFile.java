package rocks.pizzaandcoffee.mangofmt;

public class MangoFile {
    private long pointer;

    MangoFile() {
        this.pointer = LibMango.new_mango_file();
    }

    void save(String path) {
        LibMango.mangofile_save(this.pointer, path);
    }

}
