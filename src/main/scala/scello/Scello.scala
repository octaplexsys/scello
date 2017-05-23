package com.github.Jeiwan.scello

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._

/**
  * Created by Jeiwan on 23/05/2017.
  */
object Scello {
  def main(argv: Array[String]): Unit = {
    implicit val system = ActorSystem("scello-actors")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val routes = {
      pathSingleSlash {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<!DOCTYPE html><html><body><h1>Scello</h1></body></html>"))
        }
      }
    }

    Http().bindAndHandle(routes, "localhost", 3000)
    println("Server started on port 3000...")
  }
}