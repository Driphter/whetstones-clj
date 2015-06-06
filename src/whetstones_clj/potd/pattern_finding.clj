;; URL:
;; http://www.problemotd.com/problem/pattern-finding/
;;
;; Description:
;; We often solve fun number pattern riddles on here. Let's see if we can write a program to solve basic ones. Today's
;; problem is to create a program that determines if an array contains an arithmetic or geometric sequence (no sorting
;; required). Arithmetic patterns always change by the same value 2,4,6. Geometric patterns always change by the same
;; ratio 8,4,2. If the pattern doesn't match either algorithm then just return "no pattern".
;;
;; For bonus points figure out if a sequence has a plus 1 increase pattern (2,4,7,11).

(ns whetstones-clj.potd.pattern-finding)

(defn neighbor-pairs
  [coll]
  (if (> 2 (count coll))
    []
    (lazy-cat [[(first coll) (second coll)]]
              (neighbor-pairs (next coll)))))

(defn all-equal?
  [coll]
  (if (empty? coll)
    true
    (let [x (first coll)]
      (every? #(= % x) coll))))

(defn arithmetic-pattern?
  [coll]
  (all-equal? (map #(apply - %) (neighbor-pairs coll))))

(defn geometric-pattern?
  [coll]
  (all-equal? (map #(apply / %) (neighbor-pairs coll))))

(defn plus-one-increase
  ([n]
   (plus-one-increase n 1))
  ([n increment]
   (let [n (+ n increment)]
     (cons n (lazy-seq (plus-one-increase n (inc increment)))))))

(defn plus-one-increase-pattern?
  [coll]
  (= coll (take (count coll) (plus-one-increase (dec (first coll))))))

(defn find-pattern
  [coll]
  (cond
    (all-equal? coll)                 :no-pattern
    (arithmetic-pattern? coll)        :arithmetic
    (geometric-pattern? coll)         :geometric
    (plus-one-increase-pattern? coll) :plus-one-increase
    :else                             :no-pattern))
