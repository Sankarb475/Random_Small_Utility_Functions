//here we will see how can we remove duplciates from a rdd

/*
The input file consists of: 
1
2
3
4
4
5
6
6
1
7
8
*/

scala> val a = sc.textFile("file:////Users/sankar.biswas/Desktop/hello.txt")
a: org.apache.spark.rdd.RDD[String] = file:////Users/sankar.biswas/Desktop/hello.txt MapPartitionsRDD[20] at textFile at <console>:46

scala> a.collect.foreach(println)
1
2
3
4
4
5
6
6
1
7
8

scala> val b = a.map(l => (l,1)).reduceByKey((a,b) => a+b)
b: org.apache.spark.rdd.RDD[(String, Int)] = ShuffledRDD[27] at reduceByKey at <console>:50

scala> b.collect.foreach(println)
(4,2)
(8,1)
(6,2)
(2,1)
(7,1)
(5,1)
(3,1)
(1,2)

scala> val c = b.map(element => element._1)
c: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[28] at map at <console>:50

//duplicates has been removed, distinct values are being printed out
scala> c.collect.foreach(println)
4
8
6
2
7
5
3
1
