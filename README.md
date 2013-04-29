# memorize-clj

A small Clojure library providing a way to memorize pure function results
inspired in Groovy's memorize().

It supports pure functions and should only used if the function is really slow.

Clojure.core has something like this already (memoize) but noticed
after writting this. So, move along.

## Installing

lein dep:
```
[memorize-clj "0.1.0"]
```
Maven
```
<dependency>
  <groupId>memorize-clj</groupId>
  <artifactId>memorize-clj</artifactId>
  <version>0.1.0</version>
</dependency>
```

## Usage

```Clojure
(def cachedfunc (memorize yourfunc count concurrency))
```

Then `cachedfunc` will be a proxy for `yourfunc` that will use
a `com.google.common.cache.Cache` to cache results.

The parameter `count` is optional and configures how much results
are cached. By default is 1000. When provided you can also pass
the parameter `yourfunc` that configures how much threads are
expected to use the cache concurrently. By default is 32.

Make sure your function is really "PURE". It means its results
are based on its parameters and nothing more.
 
## License

Copyright © 2013

Distributed under the Eclipse Public License, the same as Clojure.
