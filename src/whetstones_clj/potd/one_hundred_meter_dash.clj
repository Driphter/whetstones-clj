;; URL:
;; http://www.problemotd.com/problem/100m-dash/
;;
;; Description:
;; A brother and sister run the 100m dash after school to practice for an upcoming track meet. In the first race the
;; sister beats her brother by 5 yards. They decide to race again but to make things more fair the sister then starts 5
;; yards behind the original starting line and they race again. Assuming the brother and sister run at the same speed as
;; they did during the first race, who wins the second race?

(ns whetstones-clj.potd.one-hundred-meter-dash)

(defn- yards->meters
  [yards]
  (/ yards 1.0936))

(defn solution []
  (let [brospeed (- 100 (yards->meters 5))
        sisspeed 100
        brotime (/ 100 brospeed)
        sistime (/ (+ 100 (yards->meters 5)) sisspeed)]
    (if (< brotime sistime)
      :brother
      :sister)))
