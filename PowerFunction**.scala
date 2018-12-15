import scala.math.pow

implicit class PowerFunction(i: Int) {
    def ** (b: Int): Int = pow(i, b).intValue
}

//output will be 3125, ** now works similar to pow function and being implicits in nature doesnt require instantiation
val a = 5**5
