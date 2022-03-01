package readcsv

import PrintResultHelpers._
import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level, Logger}

object MovieReviewApp extends App {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org") .setLevel(Level.ERROR)

    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.master", "local")
      .getOrCreate()
    val movies = spark.read.option("header", "true")
      .csv(path = "/Users/supriyadarshini/Documents/Scala Assignment/movies_dataset.csv")
    movies.show()

    printResult(
      question = "english movies",
      answers = {
        val EnglishMovies =
          movies.filter(_.language == "English")
            .take(5)
        Add type annotation to value definition.map { movie =>
          s"[LANG: ${movie.language}, " +
            s"PUBLISHED YEAR: ${movie.year.getOrElse(unknown)}] " +
            s"${movie.title} (${movie.original_title})"
        }
      }
    ) //Title, published year, budget, user reviews,country,genre,duration


  }
}
