package rocks.pizzaandcoffee.mangofmt;

import com.sun.jna.Library;
import com.sun.jna.Native;

interface LibMango extends Library  {
    LibMango INSTANCE = (LibMango) Native.loadLibrary( "mango", LibMango.class);

    long mangofile_new();
    void mangofile_free(long pointer);
    int mangofile_save(long pointer, String path);
    int mangofile_add_image_by_path(long pointer, String path);

    int mangofile_get_image_count(long pointer);
}