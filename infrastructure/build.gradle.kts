import Dependencies.exposed
import Dependencies.exposedJdbc
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
    implementJackson()

    implementation(logback)
    implementation(hikaricp)
    implementation(exposed)
    implementation(exposedJdbc)
    implementation(postgresql)
    implementation(flywaydb)

    testImplementation(kotestRunner)
}
