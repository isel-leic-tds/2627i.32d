package palbp.demos.tds.isel.ui

/**
 * Abstraction used to aggregate all display operations.
 */
interface Display {
    /**
     * Shows the given message on the display.
     * @param message the message to be displayed
     */
    fun show(message: String)

    /**
     * Moves the cursor to the next line.
     */
    fun newLine()
}

/**
 * An implementation of the [Display] interface that prints to the console.
 */
object ConsoleDisplay : Display {
    override fun show(message: String) {
        print(message)
    }

    override fun newLine() {
        println()
    }
}

