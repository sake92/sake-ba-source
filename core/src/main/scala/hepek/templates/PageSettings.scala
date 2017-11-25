package hepek.templates

/**
 * Page settings bundle.
 */
trait PageSettings {

  /**
   * @return Title of the page. Used in "title" and "h1".
   */
  def pageTitle: String

  /**
   * @return Label for links.
   */
  def pageLabel: String = pageTitle

  /**
   * Used for grouping pages. E.g. a link label in navbar for each category.
   * @return Category of the page.
   */
  def pageCategory: Option[String] = None

}
