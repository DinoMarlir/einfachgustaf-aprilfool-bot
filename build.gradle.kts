val kord_version: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
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

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = "live.einfachgustaf.discord.bot.aprilfool.ApplicationKt";
    }
    archiveFileName.set("aprilfoolbot.jar")
}

/*
tasks.register<Zip>("createDistribution") {
    dependsOn("shadowJar")

    archiveFileName.set("aprilfoolbot.zip")

    from(file("scripts")) {
        include("start.sh")
    }

    from(file("libs/aprilfoolbot.jar"))

    destinationDirectory.set(layout.buildDirectory.dir("distributions"))
}
*/