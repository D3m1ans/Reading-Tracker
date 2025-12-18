import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    kotlin {
        compilerOptions{
            jvmTarget = JvmTarget.fromTarget("11")
        }
    }
}

dependencies{
    implementation(libs.coroutines.android)
}
