plugins {
    id("com.android.application") version "7.4.2"
    kotlin("android") version "1.6.21"
}

android {
    compileSdkVersion(33)

    defaultConfig {
        applicationId = "com.example.namespace" // Replace with your desired applicationId
        minSdkVersion(24)
        targetSdkVersion(33)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // Add the following line to specify the namespace
        namespace = "com.example.namespace" // Replace with your desired namespace
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // Add additional release-specific configurations here if needed
        }
        // Add additional build types (e.g., debug, custom) if needed
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // Add additional configurations such as buildFeatures, flavorDimensions, etc. if needed
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Add more dependencies as needed

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.daimajia.easing:library:2.0@aar")
    implementation("com.daimajia.androidanimations:library:2.3@aar")
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.23")

}
