val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.8.10"
    id("io.ktor.plugin") version "2.2.4"
                id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
}

group = "com.binbraw"
version = "0.0.1"
application {
    mainClass.set("com.binbraw.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    var exposed_version = "0.41.1"
    var koin_version = "3.2.0"
    var hikari_version = "5.0.1"

    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-apache-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")

    //Loggin
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    //CORS handler
    implementation("io.ktor:ktor-server-cors-jvm:$ktor_version")

    //Json
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")

    //Authentication
    implementation("io.ktor:ktor-server-auth-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:$ktor_version")

    //Koin DI
    implementation("io.insert-koin:koin-ktor:$koin_version")

    //Exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")

    //Hikari
    implementation("com.zaxxer:HikariCP:$hikari_version")
}