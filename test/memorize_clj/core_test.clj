(ns memorize-clj.core-test
  (:use clojure.test
        memorize-clj.core))

(deftest single-param
  (testing "functions with single param"
    (let [ff (memorize (fn [x] (do (Thread/sleep x) x)))]
      (do
        (is 5000 (time (ff 5000)))
        (is 0 (time (ff 5000)))
        (is 5000 (ff 5000))))))

(deftest multiple-params
  (testing "functions with more than one parameter"
    (let [ff (memorize (fn [x y] (do (Thread/sleep x) (+ x y))))]
      (do
        (is 5000 (time (ff 5000 2)))
        (is 0 (time (ff 5000 2)))
        (is 5002 (ff 5000 2))
        (is 623 (ff 23 600))))))

(deftest deep-collections
  (testing "using collections inside parameters"
    (let [ff (memorize (fn [x] (do (Thread/sleep 1000) x)))]
      (is 1000 (time (ff [:a :b])))
      (is 0 (time (ff [:a :b])))
      (is [:a :b] (ff [:a :b]))
      (is 1000 (time (ff [:a [:b :c]])))
      (is 0 (time (ff [:a [:b :c]])))
      (is [:a [:b :c]] (ff [:a [:b :c]])))))
