import Dependencies.ktorServerTest
import Dependencies.logback
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    application
    id("com.github.johnrengelman.shadow") version "6.1.0"
    kotlin("jvm")
}

group = "jp.justincase.lotusroot"
version = "0.0.1"

application {
    mainClassName = "jp.justincase.lotusroot.ApplicationKt"
}

@Suppress("UnstableApiUsage")
tasks.getByName<ShadowJar>("shadowJar") {
    archiveBaseName.set("app")
    archiveClassifier.set("")
    archiveVersion.set("")
}

dependencies {
    implementKotlin()
    implementKtor()

    implementation(project(":core"))
    implementation(project(":data"))
    implementation(project(":web:user"))

    implementation(logback)

    testImplementation(ktorServerTest)
}
