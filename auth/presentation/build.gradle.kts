plugins {
    alias(libs.plugins.justrun.android.library)
}

android {
    namespace = "com.weijia.auth.presentation"
}

dependencies {
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
}