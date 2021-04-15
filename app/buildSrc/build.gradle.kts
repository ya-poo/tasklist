buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", "1.4.30"))
    }
}
plugins {
    kotlin("jvm") version "1.4.30"
    `kotlin-dsl`
}
repositories {
    mavenCentral()
    jcenter()
}
dependencies {
    implementation(kotlin("gradle-plugin"))
}
