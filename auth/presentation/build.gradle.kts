plugins {
    alias(libs.plugins.justrun.android.feature.ui)
}

android {
    namespace = "com.weijia.auth.presentation"
}

dependencies {
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
}