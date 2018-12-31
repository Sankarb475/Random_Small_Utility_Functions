//Spark UDF
//User-Defined Functions (aka UDF) is a feature of Spark SQL to define new Column-based functions 
//upperUDF is a user defined function
import org.apache.spark.sql.functions.udf

scala> val dataset = Seq((0, "hello"), (1, "world")).toDF("id", "text")
dataset: org.apache.spark.sql.DataFrame = [id: int, text: string]

scala> val upperUDF = udf(upper)
upperUDF: org.apache.spark.sql.expressions.UserDefinedFunction = UserDefinedFunction(<function1>,StringType,Some(List(StringType)))

scala> dataset.withColumn("upper", upperUDF($"text")).show
+---+-----+-----+
| id| text|upper|
+---+-----+-----+
|  0|hello|HELLO|
|  1|world|WORLD|
+---+-----+-----+

scala> dataset.withColumn("upper", upperUDF('text)).show
+---+-----+-----+
| id| text|upper|
+---+-----+-----+
|  0|hello|HELLO|
|  1|world|WORLD|
+---+-----+-----+

// the replacement of $"colName" has been found and it is 'colName 

