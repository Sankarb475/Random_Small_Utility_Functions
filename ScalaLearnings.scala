//Defining two dimensional array(10 * 10) with 'null' as default value

var myArray = Array.ofDim[String](10, 10)
val a = ArrayBuffer.fill(10,10)(null)
val a : ArrayBuffer[ArrayBuffer[String]] = ArrayBuffer.fill(10,10)("null")

//Generating all the combination subsets of a list

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
