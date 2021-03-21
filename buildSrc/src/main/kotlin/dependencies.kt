import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.kotlin

fun DependencyHandlerScope.implementKotlin() {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:${Versions.kotlin}"))
    implementation(kotlin("stdlib", Versions.kotlin))
}

fun DependencyHandlerScope.implementKtor() {
    implementation("io.ktor:ktor-server-core:${Versions.ktor}")
    implementation("io.ktor:ktor-server-netty:${Versions.ktor}")
    implementation("io.ktor:ktor-jackson:${Versions.ktor}")
}

object Dependencies {

    const val exposed = "org.jetbrains.exposed:exposed:${Versions.exposed}"

    const val ktorServerTest = "io.ktor:ktor-server-tests:${Versions.ktor}"

    const val logback = "ch.qos.logback:logback-classic:${Versions.logback}"

}

private fun DependencyHandlerScope.implementation(dependencyNotation: Any) {
    add("implementation", dependencyNotation)
}
