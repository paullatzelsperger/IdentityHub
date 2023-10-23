/*
 *  Copyright (c) 2022 Microsoft Corporation
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Amadeus - initial API and implementation
 *
 */

plugins {
    `java-library`
    id("application")
    alias(libs.plugins.shadow)
}

dependencies {
    runtimeOnly(project(":core:identity-hub-api"))
//    runtimeOnly(project(":core:identity-hub-credentials-verifier"))
//    runtimeOnly(project(":extensions:identity-hub-api"))
//    runtimeOnly(project(":extensions:self-description-api"))
    runtimeOnly(libs.bundles.connector)
//    runtimeOnly(libs.edc.ext.identity.did.core)
//    runtimeOnly(libs.edc.ext.identity.did.web)
}

application {
    mainClass.set("org.eclipse.edc.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    exclude("**/pom.properties", "**/pom.xm")
    mergeServiceFiles()
    archiveFileName.set("identity-hub.jar")
}

edcBuild {
    publish.set(false)
}
