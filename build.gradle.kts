import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    mavenLocal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("/Users/nathanmeade/.m2/repository")
}

//dependencies {
//    implementation("org.example.untitled1:1.1-SNAPSHOT")
//}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
//                implementation("io.nacular.doodle:doodle:0.3.4")
//                implementation("io.github.microutils:kotlin-logging:3.0.5")
//                implementation("io.github.oshai:kotlin-logging:4.0.0-beta-22")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("com.github.ajalt.clikt:clikt:3.5.2")
//                implementation("io.github.oshai:kotlin-logging-jvm:4.0.0-beta-22")
//                implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
                implementation(compose.desktop.currentOs)
//                implementation("io.nacular.doodle:doodle:0.3.4")
//                implementation("org.example.untitled1:1.1-SNAPSHOT")
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "composeMultiMac"
            packageVersion = "1.0.0"
            macOS {
                bundleID = "com.meadetechnologies.composeMultiMac"
                signing {
                    sign.set(true)
                    identity.set("John Doe")
                    // keychain.set("/path/to/keychain")
                }
            }

        }
    }
}
