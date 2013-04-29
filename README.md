# memorize-clj

A small Clojure library providing a way to memorize pure function results
inspired in Groovy's memorize().

It supports pure functions and should only used if the function is really slow.

## Usage

```Clojure
(def cachedfunc (memorize yourfunc count concurrency))
```

Then `cachedfunc` will be a proxy for `yourfunc` that will use
a `com.google.common.cache.Cache` to cache results.

Make sure your function is really "PURE". It means its results
are based on its parameters and nothing more.

## License

Copyright © 2013

Distributed under the Eclipse Public License, the same as Clojure.
