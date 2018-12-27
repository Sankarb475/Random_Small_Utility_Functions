//Higher Order Function => Function which takes a function as input and/or returns a function as output

scala> def dumdum : (String => String) = _.toUpperCase
dumdum: String => String

scala> dumdum
res26: String => String = <function1>

scala> val a = "My name is Anthony"
a: String = My name is Anthony

scala> val b = a.toUpperCase
b: String = MY NAME IS ANTHONY

scala> val c = dumdum(a)
c: String = MY NAME IS ANTHONY

// I will convert this function into a Spark UDF in sparkLearnings.scala file in this repository only

