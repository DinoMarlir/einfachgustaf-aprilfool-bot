val kord_version: String by project

plugins {
    kotlin("jvm") version "1.9.22"
}

group = "live.einfachgustaf"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.kord", "kord-core", kord_version)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}