/* SimpleApp.scala */
import org.apache.spark.sql.SparkSession

object SimpleApp {
  
  def main(args: Array[String]) {
    var logFile = args(0)
    println(s"Run logfile: $logFile")
    val spark = SparkSession.builder.appName("Simple Applicaion").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}
