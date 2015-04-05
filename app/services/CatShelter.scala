package services

import models.Cat

import play.Logger
import play.api.Play.{configuration, current}

import me.verticale.imgur.Imgur

/** The cat shelter, where cats live and rest peacefully
  * Handle everything Imgur related
  */
object CatShelter {
    val cats = createCats()
    val imgur = new Imgur(configuration.getString("imgur.key").get)

    /** Create all cats from the Imgur album
      *
      * @return An array containing all cats
      */
    def createCats(): Array[Cat] = {
      Logger.info("[ImgurService] Creating cats...")

      // Retrieve images from the album "imgur.album"
      // Map each image to create a list with Cat instances
      val cats = imgur.albumImages(configuration.getString("imgur.album").get)
        .map(Cat(_))
        .toArray

      Logger.info("[ImgurService] Cats created!")

      cats
    }
}
