package hepek.templates

import ba.sake.hepek.core.RelativePath

/**
 * Site settings bundle.
 */
trait SiteSettings {

  /**
   * @return Plain name of the site, e.g. "sake.ba"
   */
  def siteName: String

  /**
   * @return Path to the index.html page of the site.
   */
  def siteIndexPage: RelativePath

  /**
   * @return Path to the favicon of the site.
   */
  def siteFaviconNormal: RelativePath

  /**
   * E.g. if you have black and white "mode" on the site...
   * @return Path to the favicon (inverted) of the site.
   */
  def siteFaviconInverted: RelativePath = siteFaviconNormal

}
