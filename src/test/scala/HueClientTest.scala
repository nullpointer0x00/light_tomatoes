import HueClient.{HueLightState, HueState}
import org.junit.Test


class HueClientTest {

  def username = ""
  def address = ""

  @Test
  def testGetLights(): Unit = {
    val result  = HueClient.getLights(address, username)
    println(result)
  }

  @Test
  def testChangeState(): Unit = {
/**
    "state": {
      "on": true,
      "bri": 254,
      "hue": 10000,
      "sat": 254,
      "effect": "none",
      "xy": [
      0.3691,
      0.3719
      ],
      "ct": 233,
      "alert": "select",
      "colormode": "xy",
      "mode": "homeautomation",
      "reachable": true
    }
 */
    var hueLightState = new HueLightState(true, 254, HueClient.GREEN, 254, "none", 23, "none", "xy","homeautomation", true)
    var result = HueClient.changeState(address, username, 9, hueLightState)
    println(result)
    Thread.sleep(5000)
    hueLightState = new HueLightState(true, 254, HueClient.RED, 254, "none", 23, "none", "xy","homeautomation", true)
    result = HueClient.changeState(address, username, 9, hueLightState)
    println(result)
  }


}
