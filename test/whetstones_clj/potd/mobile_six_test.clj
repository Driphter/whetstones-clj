(ns whetstones-clj.potd.mobile-six-test
  (:use clojure.test
        whetstones-clj.potd.mobile-six))

(deftest t-solution
  (is (= solution 153846)))
