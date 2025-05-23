plugins {
   alias(libs.plugins.android.application)
   alias(libs.plugins.kotlin.android)
   alias(libs.plugins.google.gms.google.services)
}

android {
   namespace = "com.usama.uos.bsse_reg"
   compileSdk = 35

   defaultConfig {
      applicationId = "com.usama.uos.bsse_reg"
      minSdk = 33
      targetSdk = 35
      versionCode = 1
      versionName = "1.0"

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
   }

   buildTypes {
      release {
         isMinifyEnabled = false
         proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      }
   }
   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_11
      targetCompatibility = JavaVersion.VERSION_11
   }
   kotlinOptions {
      jvmTarget = "11"
   }
}

dependencies {

   implementation(libs.androidx.core.ktx)
   implementation(libs.androidx.appcompat)
   implementation(libs.material)
   implementation(libs.androidx.activity)
   implementation(libs.androidx.constraintlayout)
   implementation(libs.firebase.auth)
   implementation(libs.firebase.database)
   testImplementation(libs.junit)
   androidTestImplementation(libs.androidx.junit)
   androidTestImplementation(libs.androidx.espresso.core)

   implementation("com.google.code.gson:gson:2.13.1")

   implementation ("androidx.room:room-runtime:2.5.1")
   annotationProcessor ("androidx.room:room-compiler:2.5.1")
   implementation ("androidx.room:room-testing:2.5.1")





}