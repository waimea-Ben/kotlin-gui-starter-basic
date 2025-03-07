/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton
    private lateinit var textbox: JTextField

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 480)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val font = Font(Font.SANS_SERIF, Font.PLAIN, 30)

        greetingLabel = JLabel("Click a button...")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 50, 500, 100)
        greetingLabel.font = font
        add(greetingLabel)

        textbox = JTextField()
        textbox.bounds = Rectangle(50, 175, 500, 100)
        textbox.font = font
        textbox.addActionListener(this)
        textbox.addKeyListener(this)
        add(textbox)

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(50, 325, 225, 100)
        helloButton.background = Color(120, 120, 200)
        helloButton.font = font
        helloButton.foreground = Color.DARK_GRAY
        helloButton.addActionListener(this)     // Handle any clicks
        add(helloButton)

        goodbyeButton = JButton("Goodbye!")
        goodbyeButton.bounds = Rectangle(325, 325, 225, 100)
        goodbyeButton.background = Color(120, 120, 200)
        goodbyeButton.font = font
        goodbyeButton.foreground = Color.DARK_GRAY
        goodbyeButton.addActionListener(this)     // Handle any clicks
        add(goodbyeButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

            textbox -> {
                println("text changed")
            }

            helloButton -> {
                println("hello button")
                greetingLabel.foreground = Color.GREEN
                if (textbox.text.isNotEmpty()) {
                    greetingLabel.text = "Hello there, ${textbox.text}!"
                } else {
                    greetingLabel.text = "Hello!"
                }
            }


            goodbyeButton -> {
                println("goodbye button")
                greetingLabel.foreground = Color.RED
                if (textbox.text.isNotEmpty()) {
                    greetingLabel.text = "Goodbye, ${textbox.text}!"
                } else {
                    greetingLabel.text = "Goodbye!"
                }
            }
        }
    }


    override fun keyPressed(e: KeyEvent?) {
        if(e?.keyCode in KeyEvent.VK_A..KeyEvent.VK_Z) {
            println("letter key")
        }
        else{
            e?.consume()
        }
    }

    override fun keyTyped(e: KeyEvent?) {
        println("key typed")
    }


    override fun keyReleased(e: KeyEvent?) {
        println("key released: ${e?.keyCode}")
    }
}