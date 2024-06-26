import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("plugin.jpa") version "1.8.10"
    kotlin("plugin.spring") version "1.8.10"
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis:2.7.5")
    runtimeOnly ("com.mysql:mysql-connector-j")

    implementation("com.querydsl:querydsl-jpa:5.0.0")
    implementation("com.querydsl:querydsl-apt:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")

    implementation(project(":me-api"))
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}