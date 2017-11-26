# Paths

Trait `ClassPackageRelativePath` is meant to be extended by final pages.  
When you have an object like this:

```scala
package hepek.posts.ruby

object Index extends ClassPackageRelativePath {
  def render = "Whatever"
}
```

it will be rendered to `hepek/posts/ruby/index.html`. Handy, right? :)  
Then you can refer to it like `SomeOtherPage.relTo(Index)` and you'll get a relative path to it, for free!!!
No more stupid, error-prone "../../something/bla.html" etc.








