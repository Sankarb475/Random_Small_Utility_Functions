//Scala equivalent of Python's “in” operator which doesnt exist in Scala

implicit class ScalaInOperation[T](v: T) { 
  def in(s: Set[T]) = { s contains v }
}

val x = Set(1,2,3)

//gives Boolean true as output
2 in x
