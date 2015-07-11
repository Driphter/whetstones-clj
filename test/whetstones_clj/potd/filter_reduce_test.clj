(ns whetstones-clj.potd.filter-reduce-test
  (:require [whetstones-clj.potd.filter-reduce :refer :all]
            [clojure.test :refer :all]))

(deftest t-filter*
  (is (= '(1 3) (filter* odd? [1 2 3]))))

(deftest t-reduce*
  (is (= 6 (reduce* + [1 2 3])))
  (is (= 1 (reduce* + [1])))
  (is (= 0 (reduce* + []))))
