plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()
    implementKtor()
    implementJackson()

    implementation(project(":infrastructure"))
}
