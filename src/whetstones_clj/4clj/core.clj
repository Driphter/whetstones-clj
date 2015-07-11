(ns whetstones-clj.4clj.core
  (:use clojure.test))

(defn- -trim
  [s n]
  (subs s n (- (.length s) n)))

(defn- -format-failure
  [testform solution]
  (str "\r\ntest:\r\n" testform "\r\n\r\nsolution:\r\n" (-trim (str solution) 1)))

(defn- -problem-test
  [testform solution]
  `(is
    ~(read-string (clojure.string/replace (str testform) #"__" (-trim (str solution) 1)))
    ~(-format-failure testform solution)))

(defmacro defproblem
  [number title desc testforms & solution]
  `(deftest ~(vary-meta (symbol (str "problem-" number))
                        assoc :prob-title title
                        :prob-num number
                        :prob-desc desc)
     ~@(map #(-problem-test % solution) testforms)))
