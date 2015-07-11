(ns whetstones-clj.4clj.standard
  (:require [whetstones-clj.4clj.core :refer [defproblem]]))

; This is just to resolve the Cursive inspection
(def __)

(defproblem
  1 "Nothing but the Truth"
  "This is a clojure form. Enter a value which will make the form evaluate to true. Don't over think it! If you are
   confused, see the getting started page. Hint: true is equal to true."
  [(= __ true)]
  true)

(defproblem
  2 "Simple Math"
  "If you are not familiar with polish notation, simple arithmetic might seem confusing."
  [(= (- 10 (* 2 3)) __)]
  4)

(defproblem
  3 "Intro to Strings"
  "Clojure strings are Java strings. This means that you can use any of the Java string methods on Clojure strings."
  [(= __ (.toUpperCase "hello world"))]
  "HELLO WORLD")

(defproblem
  4 "Intro to Lists"
  "Lists can be constructed with either a function or a quoted form."
  [(= (list __) '(:a :b :c))]
  :a :b :c)

(defproblem
  5 "Lists: conj"
  "When operating on a list, the conj function will return a new list with one or more items \"added\" to the front."
  [(= __ (conj '(2 3 4) 1))
   (= __ (conj '(3 4) 2 1))]
  '(1 2 3 4))
