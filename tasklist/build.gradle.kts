import Dependencies.logback
import TestDependencies.ktorServerTest
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    application
    id("com.github.johnrengelman.shadow") version "6.1.0"
    kotlin("jvm")
}

group = "com.yapoo.tasklist"
version = "0.0.1"

application {
    mainClassName = "com.yapoo.tasklist.ApplicationKt"
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

    implementation(project(":user:profile"))
    implementation(project(":user-core"))
    implementation(project(":repository"))
    implementation(project(":model"))
    implementation(project(":infrastructure"))

    implementation(logback)

    testImplementation(ktorServerTest)
}
