plugins {
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinSerialization) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}