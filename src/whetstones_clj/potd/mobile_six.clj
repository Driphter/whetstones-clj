;; URL:
;; http://www.problemotd.com/problem/mobile-6/
;;
;; Description:
;; Today's goal is to try and find an integer where the digit in the ones column is a 6 and when the 6 is moved to the
;; front of the number, the number becomes 4 times the value of the starting number.

(ns whetstones-clj.potd.mobile-six)

(defn- move-digit-to-front
  [digit n]
  (let [s (str n)
        len (.length s)
        digit (- len digit)]
    (Integer/parseInt (str (subs s (dec digit) digit)
                           (subs s 0 (dec digit))
                           (subs s (dec digit) (dec len))))))

(defn solution []
  (->> (range)
       (map #(+ 6 (* 10 %)))
       (filter #(= (* 4 %) (move-digit-to-front 0 %)))
       first))
