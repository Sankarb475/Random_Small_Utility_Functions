scala> val df = Seq(1,2,3,4,5).toDF("ID")
df: org.apache.spark.sql.DataFrame = [ID: int]

scala> val dataFrame = df.withColumn("Age",lit(25))
dataFrame: org.apache.spark.sql.DataFrame = [ID: int, Age: int]

scala> dataFrame.show
+---+---+
| ID|Age|
+---+---+
|  1| 25|
|  2| 25|
|  3| 25|
|  4| 25|
|  5| 25|
+---+---+

scala> val dfDummy = dataFrame.cache()
dfDummy: dataFrame.type = [ID: int, Age: int]

scala> dfDummy.show
+---+---+
| ID|Age|
+---+---+
|  1| 25|
|  2| 25|
|  3| 25|
|  4| 25|
|  5| 25|
+---+---+


scala> dfDummy.printSchema
root
 |-- ID: integer (nullable = false)
 |-- Age: integer (nullable = false)

scala> dfDummy.registerTempTable("TableDummy")
warning: there was one deprecation warning; re-run with -deprecation for details

//registerTempTable() has been deprecated and createOrReplaceTempView() / createTempView has been incorporated in its place. 
//so basically if you run registerTempView(), in the background it will run the createOrReplaceTempView()


scala> dfDummy.createOrReplaceTempView("TableDummy")

scala> val sqlContext = new org.apache.spark.sql.SQLContext(sc)
warning: there was one deprecation warning; re-run with -deprecation for details
sqlContext: org.apache.spark.sql.SQLContext = org.apache.spark.sql.SQLContext@38f9e69b

scala> val data = sqlContext.sql("select * from TableDummy where ID = 2")
data: org.apache.spark.sql.DataFrame = [ID: int, Age: int]

scala> data.show
+---+---+
| ID|Age|
+---+---+
|  2| 25|
+---+---+

//If you want to import a Hive table into spark and use spark Sql




