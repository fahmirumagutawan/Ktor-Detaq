package com.binbraw

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.binbraw.configuration.*
import com.binbraw.data.api.ApiInjection
import com.binbraw.data.database.DatabaseProvider
import com.binbraw.util.getConfig
import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun main() {
    val config = getConfig(
        defaultEnvPath = "dev",
        hoconApplicationConfig = HoconApplicationConfig(ConfigFactory.load())
    )

    embeddedServer(
        Netty,
        port = config.port,
        host = config.host
    ) {
        module {
            install(Koin) {
                modules(
                    module {
                        single { config }
                        single { DatabaseProvider() }
                    },
                    ApiInjection.provide,
                )
                configurations()

            }
        }
    }.start(wait = true)
}

fun Application.configurations() {
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureRouting()
}