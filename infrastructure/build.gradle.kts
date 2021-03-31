import Dependencies.exposed
import Dependencies.flywaydb
import Dependencies.hikaricp
import Dependencies.logback
import Dependencies.postgresql
import TestDependencies.kotestRunner

plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()
    implementObjectMapper()

    implementation(logback)
    implementation(hikaricp)
    implementation(exposed)
    implementation(postgresql)
    implementation(flywaydb)

    testImplementation(kotestRunner)
}
