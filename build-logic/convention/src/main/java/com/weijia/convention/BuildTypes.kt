package com.weijia.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureBuildTypes(commonExtension: CommonExtension<*, *, *, *, *, *>, extensionType: ExtensionType) {

    commonExtension.run {

        buildFeatures {
            buildConfig = true
        }

        val apiKey = gradleLocalProperties(rootDir, providers).getProperty("API_KEY")
        val baseUrl = gradleLocalProperties(rootDir, providers).getProperty("API_BASE_URL")
        when(extensionType) {
            ExtensionType.APPLICATION -> {
                extensions.configure<ApplicationExtension> {
                    buildTypes {
                        debug {
                            configureDebugBuildType(apiKey, baseUrl)
                        }

                        release {
                            configureReleaseBuildType(apiKey, baseUrl, commonExtension)
                        }
                    }
                }
            }
            ExtensionType.LIBRARY -> {
                extensions.configure<LibraryExtension> {
                    buildTypes {
                        debug {
                            configureDebugBuildType(apiKey, baseUrl)
                        }

                        release {
                            configureReleaseBuildType(apiKey, baseUrl, commonExtension)
                        }
                    }
                }
            }
        }
    }

}

private fun BuildType.configureDebugBuildType(apiKey: String, baseUrl: String) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
    buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
}

private fun BuildType.configureReleaseBuildType(apiKey: String, baseUrl: String, commonExtension: CommonExtension<*, *, *, *, *, *>) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
    buildConfigField("String", "BASE_URL", "\"$baseUrl\"")

    isMinifyEnabled = true
    proguardFiles(commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
}