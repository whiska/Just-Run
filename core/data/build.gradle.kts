plugins {
    alias(libs.plugins.justrun.android.library)
}

android {
    namespace = "com.weijia.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}