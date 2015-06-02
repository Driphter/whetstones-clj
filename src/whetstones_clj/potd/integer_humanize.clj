;; URL:
;; http://www.problemotd.com/problem/integer-humanize/
;;
;; Description:
;; Today's problem you will hopefully find super useful. It will likely come
;; in handy in some project for the future. The goal is to convert integers
;; to their character/language equivalent. Your program should be able to do
;; up to 999 thousand. For example

(ns whetstones-clj.potd.integer-humanize
  (:require [whetstones-clj.utils :refer :all]))

(def ones
  {"0" ""
   "1" "one"
   "2" "two"
   "3" "three"
   "4" "four"
   "5" "five"
   "6" "six"
   "7" "seven"
   "8" "eight"
   "9" "nine"})

(def teens
  {"11" "eleven"
   "12" "twelve"
   "13" "thirteen"
   "14" "fourteen"
   "15" "fifteen"
   "16" "sixteen"
   "17" "seventeen"
   "18" "eighteen"
   "19" "nineteen"})

(def tens
  {"1" "ten"
   "2" "twenty"
   "3" "thirty"
   "4" "fourty"
   "5" "fifty"
   "6" "sixty"
   "7" "seventy"
   "8" "eighty"
   "9" "ninety"})

(def digit-group
  {1 "thousand"
   2 "million"
   3 "billion"
   4 "trillion"
   5 "quadrillion"})

(defn numeral->english
  [s]
  (let [length (count s)]
    (cond
      (= 1 length) (ones s)
      (= 2 length) (let [d1 (subs s 1)
                         d2 (subs s 0 1)]
                     (cond
                       (= "0" d2) (numeral->english d1)
                       (= "0" d1) (tens d2)
                       (= "1" d2) (teens s)
                       :else (str (tens d2) "-" (ones d1))))
      (= 3 length) (let [d3 (subs s 0 1)]
                     (if (= "0" d3)
                       (numeral->english (subs s 1))
                       (str (ones d3) " hundred " (numeral->english (subs s 1)))))
      (< 3 length) (let [digits (rem length 3)
                         digits (if (zero? digits) 3 digits)
                         left (subs s 0 digits)
                           right (subs s digits)]
                     (if (= "000" left)
                       (numeral->english right)
                       (str (numeral->english left)
                            " " (digit-group (quot (dec length) 3)) " "
                            (numeral->english right)))))))

(defn int->english
  [^Integer x]
  (if (zero? x)
    "zero"
    (numeral->english (str x))))

