package universe.constellation.orion.viewer.test.espresso

import androidx.test.core.app.takeScreenshot
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import universe.constellation.orion.viewer.test.framework.dumpBitmap
import java.text.SimpleDateFormat
import java.util.Date

private val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("yyMMdd_HH_mm")

class ScreenshotTakingRule : TestWatcher() {

    override fun failed(e: Throwable?, description: Description) {
        dumpBitmap(description.methodName.take(15), simpleDateFormat.format(Date()), takeScreenshot())
    }
}
