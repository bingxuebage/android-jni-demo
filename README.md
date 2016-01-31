## Android NDK 入门

### 什么是NDK?
 
- NDK是一系列工具的集合

> NDK提供了一系列的工具，帮助开发者快速开发C（或C++）的动态库，并能自动将so和java应用一起打包成apk。这些工具对开发者的帮助是巨大的。
    NDK集成了交叉编译器，并提供了相应的mk文件隔离CPU、平台、ABI等差异，开发人员只需要简单修改mk文件（指出“哪些文件需要编译”、“编译特性要求”等），就可以创建出so。
	NDK可以自动地将so和Java应用一起打包，极大地减轻了开发人员的打包工作。

- NDK提供了一份稳定、功能有限的API头文件声

> Google明确声明该API是稳定的，在后续所有版本中都稳定支持当前发布的API。从该版本的NDK中看出，这些API支持的功能非常有限，包含有：C标准库（libc）、标准数学库（libm）、压缩库（libz）、Log库（liblog）。

### 为什么使用NDK

1. 代码的保护。由于apk的java层代码很容易被反编译，而C/C++库反汇难度较大。
2. 可以方便地使用现存的开源库。大部分现存的开源库都是用C/C++代码编写的。
3. 提高程序的执行效率。将要求高性能的应用逻辑使用C开发，从而提高应用程序的执行效率。
4.  便于移植。用C/C++写得库可以方便在其他的嵌入式平台上再次使用

### 如何使用NDK
-  Android JNI 原理
> Android上层的Application和ApplicationFramework都是使用Java编写,底层包括系统和使用众多的LIiraries都是C/C++编写的。所以上层Java要调用底层的C/C++函数库必须通过Java的JNI来实现。

![](http://7xohph.com1.z0.glb.clouddn.com/20160131223059.png)
  
-  Android studio NDK 开发
1。解压NDK开发工具集
2. 打开android  studio,新建Android工程
3. 点击：File ->ProjectStructure:如图：

![](http://7xohph.com1.z0.glb.clouddn.com/20160131225242.png)

3. 在 local.properties 文件中设置ndk的路径
4. 在 gradle.properties 添加"android.useDeprecatedNdk=true"
5. 在 build.gradle 添加NDK 的配置

![](http://7xohph.com1.z0.glb.clouddn.com/20160131225205.png)

6. 添加JAVA 接口类文件
   ``` java
    package com.example.jungou.jnitest;
    
    /**
     * Created by jungou on 2016/1/28 0028.
     */
    public class JniApi {
        static {
            System.loadLibrary("jesonlib");
        }
    
        private native String getTitle();
    }

   ```
7. 添加jni文件夹

![](http://7xohph.com1.z0.glb.clouddn.com/20160131225921.png)

8. JAVA 接口类使用Alt+回车 自动修正，自动实现C代码
``` c
	#include <jni.h>

	JNIEXPORT jstring JNICALL
	Java_com_example_jungou_jnitest_JniApi_getTitle(JNIEnv *env, jobject instance) {
		// TODO
		return (*env)->NewStringUTF(env, "hello tile");
	}
```

9. 完成接口调用，测试完成

![](http://7xohph.com1.z0.glb.clouddn.com/20160131231227.png)

[demo地址](https://github.com/bingxuebage/android-jni-demo)
