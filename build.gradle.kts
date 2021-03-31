import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

tasks.getByName<Wrapper>("wrapper") {
    gradleVersion = "6.6"
}

allprojects {
    repositories {
        jcenter()
        mavenCentral()
        maven("https://jitpack.io")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            allWarningsAsErrors = true
            freeCompilerArgs = listOf("-Xinline-classes")
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
