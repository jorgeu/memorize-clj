(ns memorize-clj.core
  (import com.google.common.cache.Cache com.google.common.cache.CacheBuilder))

(defn memorize
  "make a cache with the function results using Google Guava libs"
  ([f] ; with no parameters
     (memorize f 1000 32))
  ([f size] ; with size
     (memorize f size 32))
  ([f size concurrency] ; full parameters: size and cuncurrency level
     (let [cache (-> (CacheBuilder/newBuilder)
                     (.maximumSize size)
                     (.concurrencyLevel concurrency)
                     (.build))]
       (fn [& args]
         (let [cached (.getIfPresent cache args)]
           (if (nil? cached)
             (let [value (apply f args)]
               (do
                 (.put cache args value)
                 value))
             cached))))
     ))
