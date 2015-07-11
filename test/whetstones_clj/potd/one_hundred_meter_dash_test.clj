(ns whetstones-clj.potd.one-hundred-meter-dash-test
  (:require [whetstones-clj.potd.one-hundred-meter-dash :refer :all]
            [clojure.test :refer :all]))

(deftest t-solution
  (is (= (solution) :sister)))
