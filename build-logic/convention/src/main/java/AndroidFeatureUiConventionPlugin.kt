import com.android.build.gradle.LibraryExtension
import com.weijia.convention.addUiLayerDependencies
import com.weijia.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeatureUiConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("justrun.android.library.compose")
            }

            dependencies {
                addUiLayerDependencies(target)
            }
        }
    }
}