(ns whetstones-clj.potd.pattern-finding-test
  (:require [whetstones-clj.potd.pattern-finding :refer :all]
            [clojure.test :refer :all]))

(deftest t-find-pattern
  (is (= :arithmetic        (find-pattern [2 4 6])))
  (is (= :geometric         (find-pattern [8 4 2])))
  (is (= :plus-one-increase (find-pattern [2 4 7 11])))
  (is (= :no-pattern        (find-pattern [1 1 1])))
  (is (= :no-pattern        (find-pattern [6 7 6 7]))))

