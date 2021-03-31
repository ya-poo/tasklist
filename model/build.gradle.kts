plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()
    implementObjectMapper()

    implementation(project(":infrastructure"))
}
