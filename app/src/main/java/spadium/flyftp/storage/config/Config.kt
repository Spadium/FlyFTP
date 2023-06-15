package spadium.flyftp.storage.config

import android.annotation.SuppressLint
import android.content.Context
import spadium.config.ConfigItem

@SuppressLint("DiscouragedApi")
fun ConfigItem<Any>.getTranslatedKeyName(key: String, context: Context): String {
    return context.getString(context.resources.getIdentifier(key, "string", context.packageName))
 }

enum class ColorModes {
    MATERIAL3, DARK, LIGHT, AMOLED, DEFAULT
}
enum class ServerType {
    FTP, FTPS
}