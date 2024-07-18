plugins {
    kotlin("jvm")
    id("kotlinx-serialization")
}

group = "org.bmsk.lifemash.repo.db.api"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation(libs.kotlinx.serialization.core)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.jackson.dataformat.xml)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}