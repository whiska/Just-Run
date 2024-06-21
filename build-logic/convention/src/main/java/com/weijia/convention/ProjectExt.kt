package com.weijia.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val Project.libs
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun Project.configureKotlinAndroid(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    commonExtension.apply {
        compileSdk = libs.findVersion("projectCompileSdkVersion").get().toString().toInt()

        defaultConfig.minSdk = libs.findVersion("projectMinSdkVersion").get().toString().toInt()

        compileOptions {
            isCoreLibraryDesugaringEnabled = true
            sourceCompatibility = JavaVersion.VERSION_1_8
            sourceCompatibility = JavaVersion.VERSION_1_8
        }

        configureKotlin()
        
        dependencies {
            "coreLibraryDesugaring"(libs.findLibrary("desugar.jdk.libs").get())
        }
    }
}

private fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>() {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}