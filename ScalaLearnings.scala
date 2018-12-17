//Defining two dimensional array(10 * 10) with 'null' as default value
//==========================================================================

var myArray = Array.ofDim[String](10, 10)
val a = ArrayBuffer.fill(10,10)(null)
val a : ArrayBuffer[ArrayBuffer[String]] = ArrayBuffer.fill(10,10)("null")

//Generating all the combination subsets of a list
//==========================================================================

val xs = List( 'a', 'b' , 'c' , 'd' , 'e','a')
val output = (1 to xs.length flatMap (x => xs.combinations(x))) map ( x => x.mkString(""))

/*output ==> output1: Seq[String] = Vector(a, b, c, d, e, aa, ab, ac, ad, ae, bc, bd, be, cd, ce, de, aab, aac, aad, aae, 
abc, abd, abe, acd, ace, ade, bcd, bce, bde, cde, aabc, aabd, aabe, aacd, aace, aade, abcd, abce, abde, acde, bcde, aabcd, 
aabce, aabde, aacde, abcde, aabcde)
*/
def combine(in: List[Char]): Seq[String] = 
    for {
        len <- 1 to in.length
        combinations <- in combinations len
    } yield combinations.mkString 

combine(xs) // Gives the same output

//Sorting two collection
//==========================================================================
val l1 = List(1,2,3) 
val l2 = List(2,3,1)

//If what you want is "these lists contain the same elements, irrespective of order or repetitions":
l1.toSet == l2.toSet  //output = true , because there are no duplicate elements

//If what you want is "these lists contain the same elements, and with the same number of repetitions of each":
l1.sorted == l2.sorted  //output = true

//If what you want is "these lists contain the same elements and are the same size, but the number of repetitions of a 
//given element can differ between the two lists":
l1.size == l2.size && l1.toSet == l2.toSet


//Definign multiple parameters at a time
//==========================================================================

scala> val (l,r) = (1,2)
l: Int = 1
r: Int = 2


scala> val (l,r,m) = (1,2,Array.range(1,5))
l: Int = 1
r: Int = 2
m: Array[Int] = Array(1, 2, 3, 4)

