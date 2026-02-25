# Dashboard

Dashboard is a modern Android intelligence dashboard built with **Kotlin + Jetpack Compose**.  
It brings real-time insights from:

- **Khoj API** (knowledge/retrieval context)
- **Mausam API** (weather intelligence)
- **Vaayu API** (air quality and environmental signals)

The app also includes **Firebase Authentication** for secure user onboarding and session management.

## What This App Delivers

- Unified home dashboard with knowledge, weather, and air quality cards
- Personalized data feed based on authenticated user context
- Real-time updates with resilient loading/error states
- Responsive UI built fully in Jetpack Compose (Material 3)
- Production-ready auth flow with Firebase Email/Password and Google Sign-In

## Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose + Material 3
- **Architecture:** MVVM + StateFlow
- **Async:** Kotlin Coroutines
- **Dependency Management:** Gradle Version Catalog (`libs.versions.toml`)
- **Authentication:** Firebase Auth
- **Build:** Android Gradle Plugin, Kotlin Compose plugin

## Project Structure

```text
app/
  src/main/java/com/aneesh/dashboard_new/
    feature/            # Feature-first modules (news, weather, air, etc.)
    ui/theme/           # Compose theme, color, typography
    MainActivity.kt     # App entry point
  src/main/res/         # Android resources
gradle/libs.versions.toml
```

## Prerequisites

- Android Studio (latest stable)
- JDK 11+
- Android SDK (minSdk 30, targetSdk 36)
- A Firebase project
- API access for Khoj, Mausam, and Vaayu

## Setup

### 1. Clone and Open

```bash
git clone <your-repo-url>
cd dashboard_new
```

Open the project in Android Studio and let Gradle sync.

### 2. Configure API Keys

Create or update `local.properties` in the project root:

```properties
KHOJ_API_KEY=your_khoj_api_key
MAUSAM_API_KEY=your_mausam_api_key
VAAYU_API_KEY=your_vaayu_api_key
```

Recommended:
- Keep keys out of source control.
- Inject keys through Gradle `BuildConfig` fields for runtime access.

### 3. Configure Firebase Auth

1. Create a Firebase project.
2. Add an Android app with package name:
   - `com.aneesh.dashboard_new`
3. Download `google-services.json` and place it in:
   - `app/google-services.json`
4. Enable auth providers in Firebase Console:
   - Email/Password
   - Google Sign-In (optional but recommended)

## Build and Run

From Android Studio:
- Select the `app` configuration
- Run on an emulator or connected device

From terminal:

```powershell
.\gradlew.bat assembleDebug
.\gradlew.bat installDebug
```

## Core User Flows

- Sign up / sign in with Firebase Auth
- View personalized dashboard data
- Explore contextual insights from Khoj
- Check current weather and forecast via Mausam
- Monitor air quality trends via Vaayu
- Refresh data on demand with cached fallback behavior

## Quality and Testing

- Unit tests for domain logic and ViewModels
- Instrumentation tests for critical app flows
- Compose UI tests for core screens and interactions

Run checks:

```powershell
.\gradlew.bat test
.\gradlew.bat connectedAndroidTest
```
