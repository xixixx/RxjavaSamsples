#include <jni.h>
#include <string>

extern "C"
jstring
Java_rxjava_zyh_com_rxjavasamsples_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
Java_rxjava_zyh_com_rxjavasamsples_MainActivity_sort(JNIEnv *env)
    {

    }
}
