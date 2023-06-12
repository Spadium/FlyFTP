package spadium.flyftp.serialization

import android.content.Context
import android.util.Log
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

@Serializable
data class Config(var servers: List<Server>, var userSettings: UserSettings) {
    fun validateConfig() {

    }

    @OptIn(ExperimentalSerializationApi::class)
    companion object {
        fun initializeConfiguration(context: Context): Config {
            val configFile = File(context.filesDir, "settings.json")
            val fileWriter: FileWriter
            val bufferedWriter: BufferedWriter
            if (!configFile.exists()) {
                Log.w("FlyFTP", "Config file not found. Creating default settings.json")
                fileWriter = FileWriter(configFile)
                bufferedWriter = BufferedWriter(fileWriter)
                configFile.createNewFile()
                bufferedWriter.write(Json.encodeToString(config))
                bufferedWriter.close()
            } else {
                val currentConfigStream = context.openFileInput("settings.json")
                Log.d("FlyFTP", "Config file found, loading")
                config = Json.decodeFromStream(currentConfigStream)
                currentConfigStream.close()
            }
            return config
        }
    }

}

@Serializable
data class UserSettings(
    var colorMode: ColorModes,
    var navBarLabels: Boolean,
    var askForDownloadDirectory: Boolean,
)

enum class ColorModes {
    MATERIAL3, DARK, LIGHT, AMOLED, DEFAULT
}

@Serializable
data class Server(
    val name: String?,
    val address: String,
    val port: Int,
    val type: ServerType,
    val users: Map<String, String?>
)

enum class ServerType {
    FTP, FTPS
}

public var config: Config = Config(
    servers = emptyList(),
    userSettings = UserSettings(
        colorMode = ColorModes.DEFAULT,
        navBarLabels = true,
        askForDownloadDirectory = true
    )
)