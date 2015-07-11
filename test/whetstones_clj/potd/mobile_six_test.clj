(ns whetstones-clj.potd.mobile-six-test
  (:require [whetstones-clj.potd.mobile-six :refer :all]
            [clojure.test :refer :all]))

(deftest t-solution
  (is (= (solution) 153846)))
