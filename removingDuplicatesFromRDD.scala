//here we will see how can we remove duplciates from a rdd
//create a paired rdd and apply aggregation on values against the key

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

//creating a paired rdd and doing aggregation on values
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

scala> val b = a.map(b => (b,1))groupByKey()
b: org.apache.spark.rdd.RDD[(String, Iterable[Int])] = ShuffledRDD[68] at groupByKey at <console>:51

scala> b.collect.foreach(println)
(7,CompactBuffer(1))
(2,CompactBuffer(1))
(8,CompactBuffer(1))
(3,CompactBuffer(1))
(4,CompactBuffer(1, 1))
(5,CompactBuffer(1))
(6,CompactBuffer(1, 1))
(1,CompactBuffer(1, 1))
