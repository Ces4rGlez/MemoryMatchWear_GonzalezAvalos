plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "mx.utng.cfga.memorymatchwear"
    // Actualizado a 36 para cumplir con los requisitos de las librerías modernas de Compose y Core
    compileSdk = 36

    defaultConfig {
        applicationId = "mx.utng.cfga.memorymatchwear"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
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
        // Elevamos a Java 17 para evitar advertencias de compatibilidad con DataStore y Compose
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // 1. Core de Android y Ciclos de Vida
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation(libs.activity.compose)
    implementation(libs.core.splashscreen)

    // 2. Jetpack Compose para Wear OS (Material y Foundation adaptados a pantallas circulares)
    implementation(platform(libs.compose.bom))
    implementation("androidx.wear.compose:compose-material:1.4.0")
    implementation(libs.compose.foundation)

    // 3. Animaciones para el Flip de las Tarjetas en 3D
    implementation("androidx.compose.animation:animation:1.7.6")
    implementation(libs.ui)
    implementation(libs.ui.graphics)

    // 4. Componentes de Presentación (ViewModel para conectar con el Estado)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

    // 5. Capa de Datos (DataStore Preferences para guardar el mejor tiempo de juego)
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // 6. Servicios e Integración con Wearables de Google
    implementation(libs.play.services.wearable)

    // 7. Entorno de Debug, Previews y Pruebas Unitarias Locales (Criterio 7)
    implementation(libs.wear.tooling.preview)
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    // Pruebas unitarias sin emulador para el GameEngine/UseCases
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
}