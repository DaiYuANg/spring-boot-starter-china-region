import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    jacoco
    `java-library`
    id("io.freefair.lombok")
    id("me.champeau.jmh")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
//    id("org.jetbrains.kotlin.jvm")
    id("com.diffplug.spotless")
}

the<DependencyManagementExtension>().apply {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

dependencies {
    val mapstructVersion: String by project
    val guavaVersion: String by project
    val jetbrainsAnnotationsVersion: String by project
    val hutoolVersion: String by project
    val junitVersion: String by project
    val testContainersVersion: String by project
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains:annotations:${jetbrainsAnnotationsVersion}")
    implementation("cn.hutool:hutool-all:${hutoolVersion}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.mapstruct:mapstruct:${mapstructVersion}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.2")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-data-redis")
    testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
    implementation(platform("org.testcontainers:testcontainers-bom:${testContainersVersion}"))
    testImplementation("com.redis.testcontainers:testcontainers-redis-junit:1.6.4")
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
}

tasks {
    withType<BootJar> {
        enabled = false
    }

    withType<Jar> {
        enabled = true
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }

    withType<JavaCompile> {
        dependsOn("processResources")
    }
    test {
        useJUnitPlatform()
    }
}

spotless {
    format("misc") {
        target("*.md", ".gitignore", "**/*.java")
        indentWithTabs() // or spaces. Takes an integer argument if you don't like 4
        endWithNewline()
    }
    java {
        target("**/*.java")
        importOrder()
        palantirJavaFormat()
        indentWithTabs()
        removeUnusedImports()
        formatAnnotations()
    }

    kotlinGradle {
        target("**/*.gradle.kts") // default target for kotlinGradle
        ktfmt() // or ktfmt() or prettier()
    }
}

java {
    val jdkVersion: String by project
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(jdkVersion))
    }
}

