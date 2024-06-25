plugins {
    alias(libs.plugins.justrun.android.library)
    alias(libs.plugins.justrun.jvm.ktor)
}

android {
    namespace = "com.weijia.auth.data"
}

dependencies {
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)
}