import java.io.File

import org.junit.Assert.assertEquals
import org.junit.Test

class RestServiceTest {

  @Test
  def testHttpGet(): Unit = {
    var content = RestService.httpGet("http://www.cnn.com")
    assertEquals(content, "fail");
  }

}
