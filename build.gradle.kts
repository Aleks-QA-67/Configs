plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.seleniumhq.selenium:selenium-java:4.20.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.8.0")
    implementation("org.assertj:assertj-core:3.27.7")
    implementation("io.rest-assured:rest-assured:5.5.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("io.rest-assured:json-path:5.4.0")
    implementation("io.rest-assured:xml-path:5.4.0")
    testImplementation("com.codeborne:selenide:7.5.0")
}

tasks.test {
    useJUnitPlatform()
}