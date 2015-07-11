(ns whetstones-clj.potd.integer-humanize-test
  (:require [whetstones-clj.potd.integer-humanize :refer :all]
            [clojure.test :refer :all]))

(deftest t-int->english
  (is (= "zero" (int->english 0)))
  (is (= "nine" (int->english 9)))
  (is (= "two hundred fourty-five" (int->english 245)))
  (is (= "ninety-nine thousand nine hundred ninety-nine" (int->english 99999))))
