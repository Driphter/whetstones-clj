(ns whetstones-clj.potd.one-hundred-meter-dash-test
  (:use clojure.test
        whetstones-clj.potd.one-hundred-meter-dash))

(deftest t-solution
  (is (= (solution) :sister)))
