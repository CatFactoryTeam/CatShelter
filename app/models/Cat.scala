package models

import me.verticale.imgur.model.Image

/** A cat factory -- literally... yep the pattern ;) */
object Cat {

  /** Create a new cat from the given image
    *
    * @param img Image's data
    *
    * @return A soft and warm cat
    */
  def apply(img: Image) = new Cat(img.id.get, img.link.get, img.mp4.get, img.webm.get)
}

/** A cat
  *
  * @param id Cat identifier (Imgur id)
  * @param link Link to the GIF image
  * @param mp4 Link to the MP4
  * @param webm Link to the WebM
  */
class Cat(id: String, link: String, mp4: String, webm: String)
