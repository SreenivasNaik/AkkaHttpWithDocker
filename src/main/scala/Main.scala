import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.stream.ActorMaterializer

import java.util.UUID

object Main extends App {
  implicit val system = ActorSystem("DirectivesBreakdown")
  implicit val materializer = ActorMaterializer()

  import akka.http.scaladsl.server.Directives._
  import system.dispatcher

  private lazy val taskRoute = pathPrefix("tasks")

  private lazy val createTaskRoute = taskRoute & post & pathEndOrSingleSlash

  private lazy val getTaskRoute = pathPrefix("taskdetails") & pathPrefix(JavaUUID) & get & pathEndOrSingleSlash



  val check = pathPrefix("v1") {
    createTaskRoute {
      println("In create task")
      complete(StatusCodes.OK)
    } ~ getTaskRoute { (interactionId: UUID) =>
      println(s"In Get Task task- $interactionId")
      complete(StatusCodes.OK)
    }
  }
  println("Starting HTTP Server")
  Http().bindAndHandle(check, "0.0.0.0", 9090)
}