plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.compose)
}

android {
    namespace = "site.pnpl.mira.ip"
    compileSdk = 34
    defaultConfig {
        applicationId = "site.pnpl.mira.ip"
        minSdk = 24
        targetSdk = 34
        versionCode = 4
        versionName = "1.0.3"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)

    with(compose) {
        implementation(ui)
        implementation(foundation)
        implementation(material3)
        implementation(runtime)
        implementation(components.resources)
    }

    implementation(libs.koin.compose)
    implementation(libs.koin.composeVM)
    implementation(libs.koin.compose.navigation)
    implementation(libs.androidx.activity.compose)

    implementation(libs.koin.core)
    implementation(libs.koin.android)
//    debugImplementation(libs.compose.ui.tooling)
}