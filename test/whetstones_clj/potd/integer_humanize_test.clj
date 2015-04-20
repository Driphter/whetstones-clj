(ns whetstones-clj.potd.integer-humanize-test
  (:require [clojure.test :refer :all]
            [whetstones-clj.potd.integer-humanize :refer :all]))

(deftest t-int->english
  (is (= "zero" (int->english 0)))
  (is (= "nine" (int->english 9)))
  (is (= "two hundred fourty-five" (int->english 245)))
  (is (= "ninety-nine thousand nine hundred ninety-nine" (int->english 99999))))
