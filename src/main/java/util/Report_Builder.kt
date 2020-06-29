package util

import com.rajatthareja.reportbuilder.ReportBuilder
import java.io.File
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Report_Builder {
    private val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    private val dateFormatFile: DateFormat = SimpleDateFormat("dd-MM-yyyy")
    private val date = Date()

    fun main() {
        ReportBuilder().apply {
            reportDirectory = "src/main/report/"

            // Set output report_doc file name
            reportFileName = dateFormatFile.format(date).toString() + "_TestReport"

            // Set Report Title
            reportTitle = "Service Automation Tools"

            // Set Report Color for more visit http://materializecss.com/color.html
            reportColor = Color.GREEN.toString()

            // Enable voice control for report_doc
            enableVoiceControl()

            // Add additional info for Report
            additionalInfo = mapOf("Environment" to "QA")
            additionalInfo = mapOf("Date" to dateFormat.format(date))

            // Create list or report_doc Files or Directories or URLs or JSONObject or JSONString
            val cucumberJsonReports = arrayListOf(
                File("src/main/report/cucumber.json"),
                File("src/main/report/")
            )

            // Build your report_doc
            this.build(cucumberJsonReports.toList())
        }
    }

enum class Color(var color: String) {
    ORANGE("orange lighten-4"),
    GREEN("green");

    override fun toString(): String {
        return color.toLowerCase()
    }

}
}