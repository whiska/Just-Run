plugins {
    alias(libs.plugins.justrun.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}