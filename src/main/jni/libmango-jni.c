#include "./rocks_pizzaandcoffee_mangofmt_LibMango.h"
#include <libmango.h>

JNIEXPORT jlong JNICALL Java_rocks_pizzaandcoffee_mangofmt_LibMango_new_1mango_1file 
(JNIEnv *env, jclass class) {
    MangoFile f = new_mango_file();
    return (long)f;
}

JNIEXPORT jint JNICALL Java_rocks_pizzaandcoffee_mangofmt_LibMango_mangofile_1save 
(JNIEnv *env, jclass class, jlong ptr , jstring jpath ) {
    MangoFile f = (MangoFile) ptr;


    const char *str = (*env)->GetStringUTFChars(env, jpath, 0);

    int error_code = mangofile_save(f, str);

    (*env)->ReleaseStringUTFChars(env, jpath, str);
    return error_code;
}

JNIEXPORT void JNICALL Java_rocks_pizzaandcoffee_mangofmt_LibMango_mangofile_1free
(JNIEnv *env, jclass class, jlong ptr) {
    MangoFile f = (MangoFile) ptr;

    mangofile_free(f);
}

JNIEXPORT jint JNICALL Java_rocks_pizzaandcoffee_mangofmt_LibMango_mangofile_1add_1image_1by_1path
(JNIEnv *env, jclass class, jlong ptr, jstring jpath) {
    MangoFile file = (MangoFile)ptr;

    const char *path = (*env)->GetStringUTFChars(env, jpath, 0);

    int error_code = mangofile_add_image_by_path(file, path);

    (*env)->ReleaseStringUTFChars(env, jpath, path);

    return error_code;
}

JNIEXPORT jint JNICALL Java_rocks_pizzaandcoffee_mangofmt_LibMango_mangofile_1image_1count
(JNIEnv *env, jclass class, jlong ptr) {
    MangoFile file = (MangoFile)ptr;

    return mangofile_get_image_count(file);
}

