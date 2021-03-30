import Dependencies.exposed
import Dependencies.hikaricp
import Dependencies.jacksonModuleKotlin
import Dependencies.logback
import Dependencies.postgresql
import TestDependencies.kotestRunner

plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()

    implementation(jacksonModuleKotlin)
    implementation(logback)
    implementation(hikaricp)
    implementation(exposed)
    implementation(postgresql)

    testImplementation(kotestRunner)
}
