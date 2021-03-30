plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()
    implementKtor()

    implementation(project(":repository"))
    implementation(project(":model"))
}
