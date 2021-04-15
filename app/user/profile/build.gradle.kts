plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()
    implementKtor()

    implementation(project(":user-core"))
    implementation(project(":repository"))
    implementation(project(":model"))
    implementation(project(":infrastructure"))
}
