import Dependencies.jacksonModuleKotlin
import Dependencies.logback

plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()

    implementation(jacksonModuleKotlin)
    implementation(logback)
}
