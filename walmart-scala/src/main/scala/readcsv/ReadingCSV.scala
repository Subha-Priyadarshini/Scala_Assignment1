package readcsv

import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level, Logger}

object ReadingCSV {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org") .setLevel(Level.ERROR)

    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.master", "local")
      .getOrCreate()
    val movie = spark.read.option("header", "true")
      .csv(path = "/Users/supriyadarshini/Documents/Scala Assignment/movies_dataset.csv")
    movie.show()
    }

  }
