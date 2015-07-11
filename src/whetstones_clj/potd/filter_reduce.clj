;; URL:
;; http://www.problemotd.com/problem/filter-reduce/
;;
;; Description:
;; Today's problem is a two part problem. You'll be implementing a filter function and a reduce function.
;;
;; Filter is a function that takes in a function and an array and runs each value of the array through the filter. The
;; function passed in to the filter will return either a true or false value. For all values in the array that evaluate
;; to true return that value. One example is an isOdd function with an array [1,2,3] which would return [1,3].
;;
;; Reduce is a function that takes in a function and an array and runs each value of the array through the reducer. The
;; goal is to run each item in the array through the list and then combine the output in to a single value. One example
;; is an adder function with an array [1,2,3] which would return 6.

(ns whetstones-clj.potd.filter-reduce)

(defn filter*
  [pred coll]
  (lazy-seq
   (when-let [s (seq coll)]
     (let [x (first s)]
       (if (pred x)
         (cons x (filter* pred (rest s)))
         (filter* pred (rest s)))))))

(defn reduce*
  [f coll]
  (case (count coll)
    0 (f)
    1 (first coll)
    (loop [aggregate (first coll)
           coll      (next coll)]
      (if coll
        (recur (f aggregate (first coll)) (next coll))
        aggregate))))