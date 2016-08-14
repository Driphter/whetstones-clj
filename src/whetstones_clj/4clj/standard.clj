(ns whetstones-clj.4clj.standard
  (:require [whetstones-clj.4clj.core :refer [defproblem]]))

; This is just to resolve the Cursive inspection
(def __)

(defproblem
  1 "Nothing but the Truth"
  "This is a clojure form. Enter a value which will make the form
   evaluate to true. Don't over think it! If you are confused, see the
   getting started page. Hint: true is equal to true."
  [(= __ true)]
  true)

(defproblem
  2 "Simple Math"
  "If you are not familiar with polish notation, simple arithmetic might
   seem confusing."
  [(= (- 10 (* 2 3)) __)]
  4)

(defproblem
  3 "Intro to Strings"
  "Clojure strings are Java strings. This means that you can use any of
   the Java string methods on Clojure strings."
  [(= __ (.toUpperCase "hello world"))]
  "HELLO WORLD")

(defproblem
  4 "Intro to Lists"
  "Lists can be constructed with either a function or a quoted form."
  [(= (list __) '(:a :b :c))]
  :a :b :c)

(defproblem
  5 "Lists: conj"
  "When operating on a list, the conj function will return a new list
   with one or more items \"added\" to the front."
  [(= __ (conj '(2 3 4) 1))
   (= __ (conj '(3 4) 2 1))]
  '(1 2 3 4))

(defproblem
  6 "Intro to Vectors"
  "Vectors can be constructed several ways. You can compare them with
  lists."
  [(= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))]
  :a :b :c)

(defproblem
  7 "Vectors: conj"
  "When operating on a Vector, the conj function will return a new
   vector with one or more items \"added\" to the end."
  [(= __ (conj [1 2 3] 4))
   (= __ (conj [1 2] 3 4))]
  [1 2 3 4])

(defproblem
  8 "Intro to Sets"
  "Sets are collections of unique values."
  [(= __ (set '(:a :a :b :c :c :c :c :d :d)))
   (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))]
  #{:a :b :c :d})

(defproblem
  9 "Sets: conj"
  "When operating on a set, the conj function returns a new set with
   one or more keys \"added\"."
  [(= #{1 2 3 4} (conj #{1 4 3} __))]
  2)

(defproblem
  10 "Intro to Maps"
  "Maps store key-value pairs. Both maps and keywords can be used as
   lookup functions. Commas can be used to make maps more readable,
   but they are not required."
  [(= __ ((hash-map :a 10, :b 20, :c 30) :b))
   (= __ (:b {:a 10, :b 20, :c 30}))]
  20)

(defproblem
  11 "Maps: conj"
  "When operating on a map, the conj function returns a new map with
   one or more key-value pairs \"added\"."
  [(= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))]
  {:b 2})

(defproblem
  12 "Intro to Sequences"
  "All Clojure collections support sequencing. You can operate on
   sequences with functions like first, second, and last."
  [(= __ (first '(3 2 1)))
   (= __ (second [2 3 4]))
   (= __ (last (list 1 2 3)))]
  3)

(defproblem
  13 "Sequences: rest"
  "The rest function will return all the items of a sequence except
  the first."
  [(= __ (rest [10 20 30 40]))]
  [20 30 40])

(defproblem
  14 "Intro to Functions"
  "Clojure has many different ways to create functions."
  [(= __ ((fn add-five [x] (+ x 5)) 3))
   (= __ ((fn [x] (+ x 5)) 3))
   (= __ (#(+ % 5) 3))
   (= __ ((partial + 5) 3))]
  8)

(defproblem
  15 "Double Down"
  "Write a function which doubles a number."
  [(= (__ 2) 4)
   (= (__ 3) 6)
   (= (__ 11) 22)
   (= (__ 7) 14)]
  (fn [x] (+ x x)))

(defproblem
  16 "Hello World"
  "Write a function which returns a personalized greeting."
  [(= (__ "Dave") "Hello, Dave!")
   (= (__ "Jenn") "Hello, Jenn!")
   (= (__ "Rhea") "Hello, Rhea!")]
  (fn [name] (str "Hello, " name "!")))

(defproblem
  17 "Sequences: map"
  "The map function takes two arguments: a function (f) and a sequence
   (s). Map returns a new sequence consisting of the result of applying
   f to each item of s. Do not confuse the map function with the map
   data structure."
  [(= __ (map #(+ % 5) '(1 2 3)))]
  '(6 7 8))

(defproblem
  18 "Sequences: filter"
  "The filter function takes two arguments: a predicate function (f)
   and a sequence (s). Filter returns a new sequence consisting of all
   the items of s for which (f item) returns true."
  [(= __ (filter #(> % 5) '(3 4 5 6 7)))]
  '(6 7))

(defproblem
  19 "Last Element"
  "Write a function which returns the last element in a sequence."
  {:restrictions [last]}
  [(= (__ [1 2 3 4 5]) 5)
   (= (__ '(5 4 3)) 3)
   (= (__ ["b" "c" "d"]) "d")]
  #(peek (vec %)))
