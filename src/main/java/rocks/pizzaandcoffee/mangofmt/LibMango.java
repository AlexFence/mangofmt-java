package rocks.pizzaandcoffee.mangofmt;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

interface LibMango extends Library  {
    LibMango INSTANCE = (LibMango) Native.loadLibrary( "mango", LibMango.class);

    long mangofile_new();
    void mangofile_free(long pointer);
    int mangofile_save(long pointer, String path);
    long mangofile_open(String path, int pointer);
    int mangofile_add_image_by_path(long pointer, String path);
    int mangofile_get_image_count(long pointer);
    IntByReference mangofile_get_image(long file, int id);
    
    IntByReference mangoimg_from_path(String path, IntByReference error);
    String mangoimg_get_base64_image_data(IntByReference image);
    IntByReference mangoimg_get_meta(IntByReference image);
    void mangoimg_free(IntByReference pointer);

    String mangoimgmeta_compression(IntByReference imgmeta);
    String mangoimgmeta_encryption(IntByReference imgmeta);
    String mangoimgmeta_checksum(IntByReference imgmeta);
    String mangoimgmeta_mime(IntByReference imgmeta);
    String mangoimgmeta_filename(IntByReference imgmeta);
    int[] mangoimgmeta_iv(IntByReference imgmeta);
    int mangoimgmeta_iv_size(IntByReference imgmeta);
}
