package various.map

object test {

  var capital = Map("US" -> "Washington", "France" -> "Paris")
  capital += ("India" -> "New Delhi")
  println(capital("France"))

}