plugins {
    kotlin("jvm") version "1.5.21" // Replace with your desired Kotlin version
    application
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("com.amazonaws:aws-java-sdk-s3")
    testImplementation("junit:junit:4.12")
}

application {
    mainClassName = "App"
}

dependencyManagement {
    imports {
        mavenBom("com.amazonaws:aws-java-sdk-bom:1.11.330")
    }
}

run {
    if (project.hasProperty("appArgs")) {
        args(eval(project.findProperty("appArgs") as String))
    }
}
