plugins {
    alias(libs.plugins.justrun.android.library)
}

android {
    namespace = "com.weijia.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)

    implementation(projects.core.domain)
}