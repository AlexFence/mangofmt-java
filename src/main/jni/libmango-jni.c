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

