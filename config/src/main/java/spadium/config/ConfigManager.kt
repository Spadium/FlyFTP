package spadium.config

class ConfigManager(id: String, values: ConfigManager.() -> Unit) {
    private var entryMap: MutableMap<String, ConfigItem<Any>> = mutableMapOf()

    fun getValue(key: String): Any {
        val item = entryMap[key]

        if (item != null) {
            if (item.value != null) {
                return item.value!!
            }
            return item.defaultValue
        }
        throw NullPointerException()
    }

    fun addEntry(item: ConfigItem<Any>) {
        entryMap[item.key] = item
    }
}
