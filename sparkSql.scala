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

