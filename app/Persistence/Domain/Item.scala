package Persistence.Domain
import slick.jdbc.MySQLProfile.api._

case class Item (id: Int, iName: String, desc: String, price: Double, maker: String, warranty: Double, seller: String) {

  override def toString: String = s"ID: $id, Item Name: $iName, Description: $desc, Price $price, Manufacturer: $maker, Warranty: $warranty, Seller: $seller"
}

case class Items (tag: Tag) extends Table[Item] (tag, "items"){
  def id = column[Int]("ITEM_ID", O.PrimaryKey, O.AutoInc)
  def iName = column[String]("ITEM_NAME")
  def desc = column[String]("DESC")
  def price = column[Double]("PRICE")
  def maker = column[String]("MAKER")
  def warranty = column[Double]("WARRANTY")
  def seller = column[String]("SELLER")
  def * = (id, iName, desc, price, maker, warranty, seller) <> (Item.tupled, Item.unapply)
}
