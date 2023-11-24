plugins {
    id("com.android.application") version "8.1.2"
    kotlin("android") version "1.9.20"
//    conecting firebase
    id("com.google.gms.google-services") version "4.4.0"
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
//    conecting firebase
    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("com.google.firebase:firebase-database")

    // Add more dependencies as needed

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.daimajia.androidanimations:library:2.4@aar'")
    implementation("com.nineoldandroids:library:2.4.0")
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.23")



}
