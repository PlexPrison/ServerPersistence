import net.minecrell.pluginyml.paper.PaperPluginDescription

plugins {
    java
    `java-library`
    id("com.mineplex.sdk.plugin") version "1.18.4"
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
}

group = "com.plexprison.serverpersistence"
version = "1.0.0"

tasks {
    build {
        dependsOn(named("generatePaperPluginDescription"))
    }
}

paper {
    name = "ServerPersistence"
    version = project.version.toString()
    main = "com.plexprison.serverpersistence.ServerPersistence"
    apiVersion = "1.20"

    serverDependencies {
        register("StudioEngine") {
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
    }
}