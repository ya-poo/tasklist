plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()
    implementKtor()

    implementation(project(":repository"))
    implementation(project(":model"))
    implementation(project(":infrastructure"))
}
