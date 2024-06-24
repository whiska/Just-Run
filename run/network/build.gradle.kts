plugins {
    alias(libs.plugins.justrun.android.library)
}

android {
    namespace = "com.weijia.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.run.domain)
}