package rocks.pizzaandcoffee.mangofmt;

public  class LibMango {
    static {
        System.loadLibrary("mango-jni");
    }

    public static native long new_mango_file();
    public static native void mangofile_free(long pointer);
    public static native int mangofile_save(long pointer, String path);
    public static native int mangofile_add_image_by_path(long pointer, String path);

    public static native int mangofile_image_count(long pointer);
}