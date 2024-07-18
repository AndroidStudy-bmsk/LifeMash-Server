plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlinSerialization) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}