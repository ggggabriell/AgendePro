pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "AgendePro"
include(":app")
include(":auth")
include(":common")
include(":core:navigation")
include(":core:ui")
include(":core:network")
include(":core:database")
include(":feature:calendar")
include(":feature:client")
include(":feature:home")
include(":feature:notifications")