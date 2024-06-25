plugins {
    alias(libs.plugins.justrun.android.library)
    alias(libs.plugins.justrun.jvm.ktor)
}

android {
    namespace = "com.weijia.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.run.domain)
}