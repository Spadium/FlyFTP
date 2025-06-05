package spadium.config

class ConfigManager {
    private var entryMap: MutableMap<String, ConfigItem<Any>> = mutableMapOf()

    constructor(id: String, values: ConfigManager.() -> Unit) {
        values()
    }

    fun getValue(key: String): Any {
        val item = entryMap[key]!!

        if (item.value != null) {
                return item.value
        }
        return item.defaultValue
    }

    fun getEntry(key: String): ConfigItem<Any> {
        return entryMap[key]!!
    }

    fun getEntries(keys: List<String>): List<ConfigItem<Any>> {
        val out: MutableList<ConfigItem<Any>> = mutableListOf()
        keys.forEach { str ->
            out.add(entryMap[str]!!)
        }
        return out
    }

    fun getAllEntries(): List<ConfigItem<Any>> {
        return entryMap.values.toList()
    }

    fun addEntry(item: ConfigItem<Any>) {
        entryMap.set(item.key, item)
        println("Added an entry")
    }
}
