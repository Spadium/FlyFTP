package spadium.config

class ConfigItem<T>(
    val key: String,
    val description: String,
    val defaultValue: T,
    val valueType: T,
    var value: T = defaultValue
) {
}

fun <T> createEntry(key: String, description: String, defaultValue: T): ConfigItem<T> {
    return ConfigItem<T>(key, description, defaultValue, defaultValue)
}
