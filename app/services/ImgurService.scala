package services

import models.Cat

import play.Logger
import play.api.Play

import java.util.Calendar

import me.verticale.imgur.Imgur

/** CatShelter
  *
  * Handle everything Imgur related (retrieve cats data mainly).
  */
object CatShelter {
    lazy val cats = createCats()
    val imgur = new Imgur(Play.current.configuration.getString("imgur.key").get)

    /** Create all cats from the Imgur album */
    def createCats(): Array[Cat] = {
      Logger.info("[ImgurService] Creating cats...")

      var list = Array[Cat]()
      val images = imgur.albumImages(Play.current.configuration.getString("imgur.album").get)

      for (image <- images)
        list = Cat(image.id.get, image.link.get) +: list

      Logger.info("[ImgurService] Cats created !")

      list
    }
}
