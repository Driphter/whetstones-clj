(ns whetstones-clj.4clj.core
  (:use clojure.test))

(defn- -trim
  [^String s n]
  (subs s n (- (.length s) n)))

(defn- -format-restriction-failure
  [solution restriction]
  (str "\r\nsolution:\r\n" (-trim (str solution) 1) "\r\n\r\nrestricted:\r\n" restriction "\r\n"))

(defn- -restriction-test
  [restriction solution]
  `(is (nil? (re-find ~(re-pattern (str restriction)) ~(str solution)))
       ~(-format-restriction-failure solution restriction)))

(defn- -format-failure
  [testform solution]
  (str "\r\ntest: \r\n" testform "\r\n\r\nsolution: \r\n" (-trim (str solution) 1) "\r\n"))

(defn- -problem-test
  [testform solution]
  `(is ~(read-string (clojure.string/replace (str testform) #"\b__\b" (-trim (str solution) 1)))
       ~(-format-failure testform solution)))

(defmacro defproblem
  [number title desc testforms & solution]
  (let [restrictions  (when (map? testforms) (:restrictions testforms))
        testforms     (if restrictions (first solution) testforms)
        solution      (if restrictions (rest solution) solution)]
    `(deftest ~(vary-meta (symbol (str "problem-" number))
                          assoc :prob-title title
                          :prob-num number
                          :prob-desc desc
                          :prob-restrictions restrictions)
       ~@(when restrictions (map #(-restriction-test % solution) restrictions))
       ~@(map #(-problem-test % solution) testforms))))
