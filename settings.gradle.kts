pluginManagement {
    includeBuild("build-logic")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "LifeMash-Server"
include(
    "app",
    ":repo:db:impl",
    ":repo:db:api",
)
