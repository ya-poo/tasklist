import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.kotlin

fun DependencyHandlerScope.implementKotlin() {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:${Versions.kotlin}"))
    implementation(kotlin("stdlib", Versions.kotlin))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutine}")
}

fun DependencyHandlerScope.implementKtor() {
    implementation("io.ktor:ktor-server-core:${Versions.ktor}")
    implementation("io.ktor:ktor-server-netty:${Versions.ktor}")
    implementation("io.ktor:ktor-jackson:${Versions.ktor}")
}

fun DependencyHandlerScope.implementJackson() {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:${Versions.jackson}")
    implementation("io.github.justincase-jp.jackson-kotlin-commons:textual:${Versions.jacksonKotlinCommon}")
}

object Dependencies {

    const val exposed = "org.jetbrains.exposed:exposed-core:${Versions.exposed}"

    const val exposedJdbc = "org.jetbrains.exposed:exposed-jdbc:${Versions.exposed}"

    const val hikaricp = "com.zaxxer:HikariCP:${Versions.hikaricp}"

    const val postgresql = "org.postgresql:postgresql:${Versions.postgresql}"

    const val flywaydb = "org.flywaydb:flyway-core:${Versions.flywaydb}"

    const val logback = "ch.qos.logback:logback-classic:${Versions.logback}"
}

object TestDependencies {
    const val ktorServerTest = "io.ktor:ktor-server-tests:${Versions.ktor}"

    const val kotestRunner = "io.kotest:kotest-runner-junit5:${Versions.kotest}"
}

private fun DependencyHandlerScope.implementation(dependencyNotation: Any) {
    add("implementation", dependencyNotation)
}
