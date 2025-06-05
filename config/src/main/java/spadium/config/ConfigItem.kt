package spadium.config

class ConfigItem<T>(
    val key: String,
    val description: String,
    val defaultValue: T,
    val valueType: T,
    val value: T?
)

fun <T> createEntry(key: String, description: String, defaultValue: T): ConfigItem<T> {
    return ConfigItem<T>(key, description, defaultValue, defaultValue, null)
}
