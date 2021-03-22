import Dependencies.exposed

plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()

    implementation(project(":infrastructure"))
}
