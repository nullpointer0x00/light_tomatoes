import org.apache.http.client.methods.{HttpGet, HttpPost, HttpPut, HttpRequestBase}
import org.apache.http.entity.{ContentType, StringEntity}
import org.apache.http.impl.client.HttpClientBuilder

object RestService {

  def makeRequest(method: () => HttpRequestBase): String = {
    val httpClient = HttpClientBuilder.create().build()
    val httpResponse = httpClient.execute(method.apply())
    val entity = httpResponse.getEntity()
    var content = ""
    if (entity != null) {
      val inputStream = entity.getContent()
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close
    }
    httpClient.getConnectionManager().shutdown()
    content
  }

  def httpGet(url: String): String = {
    makeRequest(() => new HttpGet(url))
  }

  def httpPost(url: String, json: String): String = {
    makeRequest(() => {
      val post = new HttpPost(url)
      post.setEntity(new StringEntity(json, ContentType.create("application/json")))
      post
    })
  }

  def httpPut(url: String, json: String): String = {
    makeRequest(() => {
      val put = new HttpPut(url)
      put.setEntity(new StringEntity(json, ContentType.create("application/json")))
      put
    })
  }
}
