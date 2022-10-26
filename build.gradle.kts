import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    `maven-publish`
    signing

    kotlin("jvm") version "1.7.20"
    id("org.jetbrains.dokka") version "1.7.20"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("com.github.ben-manes.versions") version "0.42.0"
}

repositories {
    mavenLocal()
    mavenCentral()
}

buildscript {
    dependencies {
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.7.20")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")
    implementation("commons-codec:commons-codec:1.15")
    implementation("org.projectlombok:lombok:1.18.24")
    implementation("joda-time:joda-time:2.12.0")
}

group = "io.github.eendroroy"
version = "0.0.1-alpha1"

val isReleaseVersion = true
val useGpgAgent = project.findProperty("signing.useGpgAgent")?.toString()?.toBoolean() ?: false

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    withSourcesJar()
    withJavadocJar()
}

tasks {
    dokkaJavadoc {
        outputDirectory.set(file("$buildDir/docs"))
    }

    javadoc {
        dependsOn(dokkaJavadoc)
    }
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set(project.name)
                description.set("PortWallet SDK")
                url.set("https://github.com/eendroroy/opensdk-portwallet.git")

                licenses {
                    license {
                        name.set("MIT")
                        url.set("http://opensource.org/licenses/MIT")
                        distribution.set("repo")
                    }
                }

                scm {
                    connection.set("scm:git:https://github.com/eendroroy/opensdk-portwallet.git")
                    developerConnection.set("scm:git:https://github.com/eendroroy/opensdk-portwallet.git")
                    url.set("https://github.com/eendroroy/opensdk-portwallet.git")
                }

                developers {
                    developer {
                        id.set("eendroroy")
                        name.set("indrajit")
                        email.set("eendroroy@gmail.com")
                    }
                }
            }
        }
    }

    repositories {
        maven {
            val releaseRepo = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotRepo = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            url = uri(if (isReleaseVersion) releaseRepo else snapshotRepo)
            credentials {
                username = project.findProperty("oss.user")?.toString() ?: System.getenv("OSS_USERNAME")
                password = project.findProperty("oss.key")?.toString() ?: System.getenv("OSS_TOKEN")
            }
        }
    }
}

signing {
    gradle.taskGraph.whenReady { isRequired = isReleaseVersion }
    if (useGpgAgent) {
        useGpgCmd()
    }
    sign(publishing.publications["mavenJava"])
}
