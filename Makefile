JNI_SRC = $(shell find ./src -name '*.c')
JNI_HEADERS = -I /usr/lib/jvm/java-10-openjdk/include/ -I /usr/lib/jvm/java-10-openjdk/include/linux/ 
default: jni

all: jni java

java:
	gradle

jni: src/java/main/jni/rocks_pizzaandcoffee_mangofmt_LibMango.h $(JNI_SRC)
	gcc -shared -o out/libmango-jni.so $(JNI_SRC) -lmango $(JNI_HEADERS) 

src/java/main/jni/rocks_pizzaandcoffee_mangofmt_LibMango.h:
	javac -h src/main/jni -d /tmp src/main/java/rocks/pizzaandcoffee/mangofmt/LibMango.java

