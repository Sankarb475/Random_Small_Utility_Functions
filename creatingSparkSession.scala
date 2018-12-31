import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

val appName = "Demo"
val master = "localDummy"

//using configuration, creating SparkSession
val conf: SparkConf = new SparkConf().setMaster(master).setAppName(appName).set("spark.driver.allowMultipleContexts", "false").set("spark.ui.enabled", "false")
val spark: SparkSession = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()
val sc: SparkContext = spark.sparkContext
val sqlContext: SQLContext = ss.sqlContext

//without using conf
val spark = SparkSession.builder().master("local").getOrCreate()

val spark = SparkSession.builder().getOrCreate()
