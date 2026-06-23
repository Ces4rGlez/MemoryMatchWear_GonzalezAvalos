# MemoryMatchWear 🎮⌚

**MemoryMatchWear** es un juego de memoria clásico (Memorama) diseñado específicamente para dispositivos **Wear OS**. El juego pone a prueba tu memoria mientras intentas emparejar conceptos clave del desarrollo moderno de Android en el menor tiempo posible.

## ✨ Características

-   **Optimizado para Wear OS**: Interfaz circular adaptada para pantallas pequeñas de relojes.
-   **Temática Tech**: Encuentra parejas de conceptos como `Compose`, `Flow`, `ViewModel`, y `Room`.
-   **Animaciones 3D**: Efecto de volteo de cartas fluido utilizando `animateFloatAsState` de Jetpack Compose.
-   **Persistencia de Datos**: Guarda tu mejor tiempo localmente utilizando **Jetpack DataStore**.
-   **Feedback Háptico**: Vibraciones al encontrar parejas, fallar o ganar el juego.
-   **Diseño Moderno**: Construido totalmente con **Jetpack Compose para Wear OS**.

## 🛠️ Stack Tecnológico

-   **Lenguaje**: [Kotlin](https://kotlinlang.org/)
-   **UI**: [Jetpack Compose for Wear OS](https://developer.android.com/training/wearables/compose)
-   **Arquitectura**: MVVM (Model-View-ViewModel) con Clean Architecture (Use Cases).
-   **Manejo de Estado**: StateFlow y LiveData.
-   **Almacenamiento**: DataStore Preferences.
-   **SDK Mínimo**: API 30 (Android 11).

## 📁 Estructura del Proyecto

```text
mx.utng.cfga.memorymatchwear
├── data/               # Implementación de Repositorios y DataSources (DataStore)
├── domain/             # Modelos de negocio y Casos de Uso (Lógica del Juego)
├── presentation/       # UI (Compose), ViewModels y Temas
│   ├── board/          # Pantallas de Juego y Victoria
│   └── theme/          # Configuración de Colores y Tipografía
└── MainActivity.kt     # Actividad Principal (GameActivity)
```

## 🚀 Cómo Ejecutar

1.  Clona este repositorio.
2.  Abre el proyecto en **Android Studio Koala** o superior.
3.  Crea o selecciona un Emulador de **Wear OS** (API 30+).
4.  Haz clic en **Run** para instalar y jugar.

## 🏆 Objetivo del Juego

El tablero consta de 12 cartas (6 parejas). Debes voltearlas de dos en dos para encontrar las coincidencias. El juego termina cuando todas las parejas han sido encontradas. ¡Intenta superar tu propio récord de tiempo!

---
Desarrollado por [González Avalos César Fernando](https://github.com/Ces4R) como parte de un proyecto de desarrollo para Wearables.
