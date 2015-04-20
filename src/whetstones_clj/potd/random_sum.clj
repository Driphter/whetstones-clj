;; URL:
;; http://www.problemotd.com/problem/random-sum/
;;
;; Description:
;; How to randomly pick k numbers between 0 and n such that their sum is n?

(ns whetstones-clj.potd.random-sum
  (:require [whetstones-clj.utils :refer :all]))

(defn- rand-sum-inclusive*
  [k n]
  (if (= 1 k)
    [n]
    (let [r (cond
             (pos? n) (rand-int (inc n))
             (neg? n) (rand-int (dec n))
             :else 0)]
      (concat [r] (rand-sum-inclusive* (dec k) (- n r))))))

(defn rand-sum-inclusive
  [k n]
  {:pre [(number? k) (number? n)
         (pos? k)]
   :post [(= n (apply + %))]}
  (rand-sum-inclusive* k n))

(defn- rand-sum-exclusive*
  [k n]
  (if (= 1 k)
    [n]
    (let [r (if (pos? n)
              (inc (rand-int (- n (dec k))))
              (dec (rand-int (+ n (inc k)))))]
      (concat [r] (rand-sum-exclusive* (dec k) (- n r))))))

(defn rand-sum-exclusive
  [k n]
  {:pre [(number? k) (number? n)
         (pos? k)
         (or (and (pos? n) (not (neg? (- n k))))
             (and (neg? n) (not (pos? (+ n k)))))]
   :post [(= n (apply + %))]}
  (rand-sum-exclusive* k n))
