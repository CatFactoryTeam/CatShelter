package services

import scredis.Redis

/** May contains Redis configuration */
trait RedisConfig {

}

/** Handle cats business logic with the power of Redis */
object RedisService extends RedisConfig {
  // A direct access to redis should **really** not be possible
  private val redis = Redis()

  /** Well... if you insist */
  def flushAll: Unit = redis.flushAll()
}

/** "Keeper of Keys and Grounds of Redis" (aka Rubeus Hagrid) */
object RedisSchema {

  /** Get the key to retrieve every single cats
    *
    * @ return The key
    */
  def cats: String = "cats"

  /** Get the key to retrieve a single cat
    *
    * @param id Cat identifier
    *
    * @return The key
    */
  def cat(id: String): String = s"cats:$id"
}
