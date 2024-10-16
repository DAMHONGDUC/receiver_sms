import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hiltAndroid)
}

fun loadProperties(file: File): Properties {
    val properties = Properties()
    if (file.exists()) {
        properties.load(file.inputStream())
    }
    return properties
}
// file
val localPropertiesPath = rootProject.file("local.properties")
val devPropertiesPath = rootProject.file("dev.properties")
val prodPropertiesPath = rootProject.file("prod.properties")
// Load local.properties
val localProperties = loadProperties(localPropertiesPath)
// Read properties values
val keyAliasProp = localProperties.getProperty("keyAlias") ?: ""
val keyPasswordProp = localProperties.getProperty("keyPassword") ?: ""
val storeFileProp = localProperties.getProperty("storeFile") ?: ""
val storePasswordProp = localProperties.getProperty("storePassword") ?: ""
val compileSdkProp = localProperties.getProperty("compileSdk")?.toIntOrNull() ?: 34
val minSdkProp = localProperties.getProperty("minSdk")?.toIntOrNull() ?: 24
val namespaceProp = localProperties.getProperty("namespace") ?: ""
val applicationIdProp = localProperties.getProperty("applicationId") ?: ""
val versionCodeProp = localProperties.getProperty("versionCode")?.toIntOrNull() ?: 1
val versionNameProp = localProperties.getProperty("versionName") ?: "1.0"
val targetSdkProp = localProperties.getProperty("targetSdk")?.toIntOrNull() ?: 34

android {
    namespace = namespaceProp
    compileSdk = compileSdkProp

    defaultConfig {
        applicationId = applicationIdProp
        minSdk = minSdkProp
        targetSdk = targetSdkProp
        versionCode = versionCodeProp
        versionName = versionNameProp

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file(storeFileProp)
            storePassword = storePasswordProp
            keyAlias = keyAliasProp
            keyPassword = keyPasswordProp
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    // Config multi flavor
    flavorDimensions += "environment"

    productFlavors {
        create("dev") {
            dimension = "environment"
            versionNameSuffix = "-dev"
            resValue("string", "app_name", "SMS Receiver Call API Dev")
            // Load properties from dev.properties
            val devProperties = loadProperties(file(devPropertiesPath))
            buildConfigField("String", "ENV", "\"${devProperties["ENV"]}\"")
            buildConfigField("String", "BASE_URL", "\"${devProperties["BASE_URL"]}\"")
        }
        create("prod") {
            dimension = "environment"
            resValue("string", "app_name", "SMS Receiver Call API")
            // Load properties from prod.properties
            val prodProperties = loadProperties(file(prodPropertiesPath))
            buildConfigField("String", "ENV", "\"${prodProperties["ENV"]}\"")
            buildConfigField("String", "BASE_URL", "\"${prodProperties["BASE_URL"]}\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // navigation
    implementation(libs.androidx.navigation.compose)
    // data
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // network
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    // di
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.compiler)
    // ui
    implementation(libs.androidx.material)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.sonner)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.lazycolumnscrollbar)
    // local storage
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    // permission
    implementation(libs.accompanist.permissions)
    // multi language
    implementation(libs.lyricist)
    ksp(libs.lyricist.processor)
}