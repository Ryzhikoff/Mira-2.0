plugins {
    alias(libs.plugins.kotlinMultiplatform)
//    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
//    kotlin("plugin.serialization").version("1.9.23")
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

//    cocoapods {
//        summary = "Some description for the Shared Module"
//        homepage = "Link to the Shared Module homepage"
//        version = "1.0"
//        ios.deploymentTarget = "16.0"
//        podfile = project.file("../iosApp/Podfile")
//        framework {
//            baseName = "shared"
//            isStatic = true
//        }
//    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.kotlinx.coroutines.core)

            with(compose) {
                implementation(ui)
                implementation(foundation)
                implementation(material3)
                implementation(runtime)
                implementation(components.resources)
            }

            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.composeVM)
            implementation(libs.koin.compose.navigation)

            implementation(libs.sketch.compose)
            implementation(libs.sketch.animated.gif)
            implementation(libs.sketch.compose.resources)
            implementation(libs.sketch.extensions.compose.resources)

            implementation(libs.sqldelight.runtime)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.android)
            implementation(libs.koin.android)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.sqldelight.android.driver)
        }

        iosMain.dependencies {
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.runtime)
            implementation(libs.ktor.client.darwin)
            implementation(libs.sqldelight.native.driver)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "site.pnpl.mira.ip"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("site.pnpl.mira.data.database")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/schema"))
        }
    }
}