import org.json4s._
import org.json4s.jackson.Serialization._

object HueClient {

  var username = ""
  val DEFAULT = 10000
  val RED = 65535
  val GREEN = 21845
  val BLUE = 43690

  implicit val formats = DefaultFormats
  case class HueState(state: HueLightState)
  case class HueLightState(on: Boolean, bri: Int, hue: Int, sat: Int, effect: String, ct: Int, alert: String, colormode: String, mode: String, reachable: Boolean)
  case class ErrorBody(address: String, `type`: String, description: String)
  case class ErrorResponse(error: ErrorBody)

  def changeState(address: String, username: String, light: Int, state: HueLightState): String = {
    val requestPath = s"http://$address/api/$username/lights/$light/state";
    val jsonRequest = write(state);
    println(jsonRequest)
    val response = RestService.httpPut(requestPath, jsonRequest)
    response
  }


  def getLights(address: String, username: String): String = {
    val requestPath = s"http://$address/api/$username/lights";
    val response = RestService.httpGet(requestPath)
    val json = read(response)
    response
  }

}
