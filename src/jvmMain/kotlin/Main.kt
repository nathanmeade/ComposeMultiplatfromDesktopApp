import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.github.ajalt.clikt.core.NoOpCliktCommand
//import io.github.microutils.KotlinLogging

//import io.github.oshai.KotlinLogging
//private val logger = KotlinLogging.logger {}
class SomeClass() : NoOpCliktCommand(

)

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
//    val encoder = Base64Factory.createEncoder()
    MaterialTheme {
        Button(onClick = {
            text = "Hello, Deskop!"
        }) {
            Text(text)
        }
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
