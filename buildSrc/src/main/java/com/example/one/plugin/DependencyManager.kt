package com.example.one.plugin

/**
 * 如果数量少的话，放在一个类里面就可以，如果数量多的话，可以拆分为多个类
 */

object Versions {

    val retrofit = "2.9.0"
    val okhttpLogging = "3.9.0"
    val appcompat = "1.1.0"
    val coreKtx = "1.3.0"
    val constraintlayout = "2.0.0-beta3"
    val paging = "3.0.0-alpha02"
    val timber = "4.7.1"
    val kotlin = "1.3.72"
    val work = "2.2.0"
    val room = "2.3.0-alpha01"
    val cardview = "1.0.0"
    val recyclerview = "1.0.0"
    val fragment = "1.3.0-alpha06"
    val junit = "4.12"
    val junitExt = "1.1.1"
    val espressoCore = "3.2.0"
    val runtime = "0.11.0"
    val hilt = "2.28-alpha"
    val hiltViewModule = "1.0.0-alpha01"
    val appStartup = "1.0.0-alpha01"
    val material = "1.2.0-alpha06"
    val jDatabinding = "1.0.1"
    val immersionbar = "3.0.0"
    val stateLayout = "1.0.13"
}

object AndroidX {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    val appStartup = "androidx.startup:startup-runtime:${Versions.appStartup}"
}

object Android {
    val meteria = "com.google.android.material:material:${Versions.material}"
}

object Hilt {
    val daggerRuntime = "com.google.dagger:hilt-android:${Versions.hilt}"
    val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    val viewModule = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModule}"
    val compiler = "androidx.hilt:hilt-compiler:${Versions.hiltViewModule}"
}

object Coil {
    val runtime = "io.coil-kt:coil:${Versions.runtime}"
}

object Room {
    val runtime = "androidx.room:room-runtime:${Versions.room}"
    val compiler = "androidx.room:room-compiler:${Versions.room}"
    val ktx = "androidx.room:room-ktx:${Versions.room}"
    val rxjava2 = "androidx.room:room-rxjava2:${Versions.room}"
    val testing = "androidx.room:room-testing:${Versions.room}"
}

object Fragment {
    val runtime = "androidx.fragment:fragment:${Versions.fragment}"
    val runtimeKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    val testing = "androidx.fragment:fragment-testing:${Versions.fragment}"
}

object Kt {
    val stdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val test = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Retrofit {
    val runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val mock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
    val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"
}

object Depend {

    val junit = "junit:junit:${Versions.junit}"
    val androidTestJunit = "androidx.test.ext:junit:${Versions.junitExt}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val jDatabinding = "com.hi-dhl:jdatabinding:${Versions.jDatabinding}"
    val immersionbar = "com.gyf.immersionbar:immersionbar:${Versions.immersionbar}"
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val stateLayout = "com.github.liangjingkanji:StateLayout:${Versions.stateLayout}"
}

