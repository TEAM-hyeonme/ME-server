plugins {
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.spring") version "1.8.10"
    kotlin("plugin.jpa") version "1.8.10"
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
}

subprojects {
    apply(plugin = "java")

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")

    apply {
        plugin("org.jetbrains.kotlin.kapt")
        version = "1.8.10"
    }

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}

allprojects {
    group = "shop.hyeonme"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "jacoco")

    tasks {
        compileKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "11"
            }
        }

        compileJava {
            sourceCompatibility = JavaVersion.VERSION_11.majorVersion
        }

        test {
            useJUnitPlatform()
        }
    }

    repositories {
        mavenCentral()
    }
}