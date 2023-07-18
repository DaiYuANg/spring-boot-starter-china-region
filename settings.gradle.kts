pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }

    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
//    val kotlinVersion :String by settings
    val jmhPluginVersion: String by settings
    val lombokPluginVersion: String by settings
    val spotlessPluginVersion: String by settings
    plugins {
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
//        id("org.jetbrains.kotlin.jvm") version kotlinVersion
        id("me.champeau.jmh") version jmhPluginVersion
        id("io.freefair.lombok") version lombokPluginVersion
        id("com.diffplug.spotless") version spotlessPluginVersion
    }
}

rootProject.name = "spring-boot-starter-china-region"

buildCache {
    local {
        isEnabled = true
        directory = File(rootProject.projectDir, ".gradle/build-cache")
    }
}
