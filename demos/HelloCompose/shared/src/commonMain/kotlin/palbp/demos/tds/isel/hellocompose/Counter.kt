package palbp.demos.tds.isel.hellocompose

data class Counter(val value: Int = 0) {
    init {
        require(value >= 0)
    }

    fun inc(): Counter = Counter(value = value + 1)
    fun dec(): Counter = Counter(value = if (value != 0) value - 1  else 0)
}