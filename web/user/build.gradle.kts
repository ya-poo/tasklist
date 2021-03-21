plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()
    implementKtor()

    implementation(project(":data"))
}
