import Dependencies.exposed

plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()
    implementJackson()

    implementation(project(":infrastructure"))
    implementation(project(":model"))

    implementation(exposed)
}
