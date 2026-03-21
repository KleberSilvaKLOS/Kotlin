
class Document(val text: String)

interface Printer {
  fun print(text: String): Document

  val printerType: String
}

interface TextConverter {
  fun convert(text: String, printerType: String): String

}

class PdfPrinter: Printer, TextConverter {

    override fun print(text: String): Document { 
      convert(text = text, printerType = printerType)
      println("PDF printing: $text")
      return Document(text = text)
    }

    override val printerType: String
      get() = "PDF"

    override fun convert(text: String, printerType: String): String {
      println("Covertendo texto '$text' para o tipo $printerType...")
      return text
    }

}

fun main() {

  val pdfPrinter = PdfPrinter()

  pdfPrinter.print("Hello Kotlin!")

}