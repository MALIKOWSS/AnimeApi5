plugins {
    Plugins.apply {
        id(androidLibrary)
        kotlin(android)
        kotlin(kapt)
        id(hilt)
    }
}
android {
    namespace = Config.namespaceData
    compileSdk = Config.compileAndTargetSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.compileAndTargetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Config.consumer)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(Config.proguard), Config.proguardRules)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {
    Dependencies.UIComponents.apply {
        implementation(core)
        implementation(appCompat)
        implementation(material)
    }

    Dependencies.Retrofit.apply {
        implementation(retrofit)
        implementation(retrofitConverter)
    }

    Dependencies.OkHttp.apply {
        implementation(platform(okHttpBom))
        implementation(okHttp)
        implementation(okHttpLogging)
    }

    Dependencies.Hilt.apply {
        implementation(hilt)
        kapt(hiltCompiler)
    }

    Dependencies.Domain.apply {
        implementation(project(domain))
    }
}