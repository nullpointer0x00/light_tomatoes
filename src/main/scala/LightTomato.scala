object LightTomato {

  def workMinutes: Int = 10 * 60
  def breakMinutes: Int = 5 * 60
  def largeBreakMinutes: Int = 20 * 60

  def main(args: Array[String]) {
    var elapsedSeconds = 0
    while(elapsedSeconds != workMinutes) {
      elapsedSeconds += 1
      Thread.sleep(1000)
      if(elapsedSeconds == workMinutes) {
        //HueClient.changeColor()
      }
    }
  }

}

