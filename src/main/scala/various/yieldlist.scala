/** Turn command line arguments to uppercase */
object Main {
  def main(args: Array[String]) {
    val res = for (a <- args) yield a.toUpperCase
    println("Uppercase arguments:")
    for(r <- res) {
      println(r)
    }
  }
}
