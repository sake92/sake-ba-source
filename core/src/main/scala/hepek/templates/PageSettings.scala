package hepek.templates

/**
 * Page settings bundle.
 */
trait PageSettings {

  /** Used in "title" && "h1" */
  def pageTitle: String

  /** Used in "a" links */
  def pageLabel: String = pageTitle

  /** Used for grouping pages. E.g. a link label in navbar for each category.. */
  def pageCategory: Option[String] = None

}
