enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Mira"
include(":androidApp")
include(":shared")
include(":core:storage")
include(":core:common")
include(":core:models")
include(":core:network")
include(":core:utils")