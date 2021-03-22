plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()
    implementKtor()

    implementation(project(":data"))
    implementation(project(":data-core"))
}
