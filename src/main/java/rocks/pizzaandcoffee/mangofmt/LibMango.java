package rocks.pizzaandcoffee.mangofmt;

public  class LibMango {
    static {
        System.loadLibrary("mango-jni");
    }

    public static native long new_mango_file();
    public static native int mangofile_save(long pointer, String path);
}