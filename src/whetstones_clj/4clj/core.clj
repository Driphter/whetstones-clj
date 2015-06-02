(ns whetstones-clj.4clj.core
  (:use clojure.test
        clojure.walk))

(defn- -trim
  [s n]
  (subs s n (- (.length s) n)))

(defn- -format-failure
  [test solution]
  (str "\r\ntest:\r\n" test "\r\n\r\nsolution:\r\n" (-trim (str solution) 1)))

(defn- -problem-test
  [test solution]
  `(is
    ~(read-string (clojure.string/replace (str test) #"__" (-trim (str solution) 1)))
    ~(-format-failure test solution)))

(defmacro defproblem
  [number title desc tests & solution]
  `(deftest ~(vary-meta (symbol (str "problem-" number))
                        assoc :prob-title title
                        :prob-num number
                        :prob-desc desc)
     ~@(map #(-problem-test % solution) tests)))
