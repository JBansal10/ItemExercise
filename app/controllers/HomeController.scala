package controllers

import javax.inject._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Hello to: ", "Ol' Man Piers"))
  }
  def googPage = Action { implicit request: Request[AnyContent] =>
    Redirect("http://www.google.co.uk")
    // You can also redirect to another page entirely like Redirect("www.somepage.com")
  }

  def badRequest = Action { implicit request =>
    BadRequest("Whoops this didn't work as intended...")
  }

  def indexRedirect = Action {implicit request: Request[AnyContent] =>
    Redirect("/").withSession(request.session + ("connected" -> "user@gmail.com"))
  }

  def sessionIndex = Action {implicit request =>
    Ok(views.html.index("Hi you are connected", "Ol' Man Piers"))
  }

  def sessionTest = Action { request =>
    request.session get "connected" map { user =>
      Ok("Hello" + user)
    } getOrElse {
      Unauthorized("This is most peculiar...")
    }
  }

  def comingUp: Action[AnyContent] = TODO
}
