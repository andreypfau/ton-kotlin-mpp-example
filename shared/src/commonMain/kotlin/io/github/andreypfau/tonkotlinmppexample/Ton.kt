package io.github.andreypfau.tonkotlinmppexample

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.ton.api.liteclient.config.LiteClientConfigGlobal
import org.ton.lite.client.LiteClient

class Ton {
    suspend fun initLiteClientAsync(): LiteClient = coroutineScope {
        val json = Json {
            ignoreUnknownKeys = true
        }
        val config = json.decodeFromString<LiteClientConfigGlobal>(LITE_CLIENT_CONFIG_JSON)
        LiteClient(coroutineContext, config)
    }

    fun initLiteClient() = runBlocking {
        initLiteClientAsync()
    }

    fun getLastBlockId(liteClient: LiteClient): String = runBlocking {
        liteClient.getLastBlockId().toString()
    }
}