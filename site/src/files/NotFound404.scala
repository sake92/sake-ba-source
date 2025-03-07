package files

import scalatags.Text.tags2.main
import utils.Imports._

object NotFound extends templates.SakeBaPage {

  override def pageSettings = super.pageSettings.withTitle("Not found")

  override def fileName = "404.shtml"

  override def pageContent = main(
    """
    This content is not available in your country.  
    Sorry about that. :/

    ---
    Just kidding, there's nothing here! ^_^
    
    [Go back to homepage](/)
    """.md
  )

}
