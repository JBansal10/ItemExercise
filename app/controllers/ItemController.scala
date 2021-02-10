package controllers
import Persistence.Domain.{Item, Items}
import Persistence.DAO.ItemDAO

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future._
import scala.util.{Failure, Success}

class ItemController {

  def readAll(): Unit = {
    val readAllFuture = ItemDAO.readAll()
    readAllFuture.onComplete{
      case Success(value) =>
        print("\n")
        value.foreach(println)
      case Failure(error) =>
        error.printStackTrace()
    }
  }

//  def update(): Unit = {
//    val updateFuture = ItemDAO.update()
//    updateFuture.onComplete{
//      case Success(value) =>
//        print("\n")
//        value.foreach(println)
//      case Failure(error) =>
//        error.printStackTrace()
//    }
//  }

}
