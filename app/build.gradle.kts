plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.projectkotlin2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.projectkotlin2"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        viewBinding=true
        compose= true
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
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.database)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


//
//    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
//    // https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-runtime-ktx
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.2")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.2")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.2")
//    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation( "com.google.code.gson:gson:2.9.0")
    implementation ("com.tbuonomo:dotsindicator:4.3")
   implementation(libs.firebase.database)
//    implementation(libs.androidx.activity)
//    implementation(libs.androidx.constraintlayout)

}