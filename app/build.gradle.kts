plugins {
    kotlin("jvm")
}

group = "org.bmsk.lifemash.app"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(projects.repo.db.api)
    implementation(projects.repo.db.impl)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}