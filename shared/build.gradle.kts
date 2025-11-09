plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.android.lint)
}

kotlin {

    androidLibrary {
        namespace = "com.agendepro.shared"
        compileSdk = 36
        minSdk = 28
    }

    sourceSets {
        commonMain {
            dependencies {
            }
        }

        androidMain {
            dependencies {
            }
        }

        iosMain {
            dependencies {
            }
        }
    }

}