#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_example_jungou_jnitest_JniApi_getTitle(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, "hello tile");
}