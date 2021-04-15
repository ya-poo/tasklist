plugins {
    kotlin("jvm")
}

dependencies {
    implementKotlin()
    implementJackson()

    implementation(project(":infrastructure"))
}
