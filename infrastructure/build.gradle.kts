import Dependencies.jacksonModuleKotlin
import Dependencies.logback
import TestDependencies.kotestRunner

plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()

    implementation(jacksonModuleKotlin)
    implementation(logback)

    testImplementation(kotestRunner)
}
