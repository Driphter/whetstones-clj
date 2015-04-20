(ns whetstones-clj.potd.mobile-six-test
  (:require [clojure.test :refer :all]
            [whetstones-clj.potd.mobile-six :refer :all]))

(deftest t-solution
  (is (= solution 153846)))
