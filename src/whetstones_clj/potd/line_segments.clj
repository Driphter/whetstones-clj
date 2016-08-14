;; URL:
;; http://www.problemotd.com/problem/line-segments/
;;
;; Description:
;; If you're a unix user you may be familiar with the popular command 'ls'. The 'ls' command simply prints all the
;; files and folders in a directory. Today's objective is to create a program that takes in an absolute folder path
;; and prints out all the files and folders inside that directory. For bonus points make it also work with relative
;; paths. If an invalid directory is passed simply print out "Invalid directory".

(ns whetstones-clj.potd.line-segments
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  (:import (java.io File)))

(defn ls
  ([]
   (ls "."))
  ([path]
   (let [file (io/file path)]
     (if-not (and (.exists file) (.isDirectory file))
       (println "Invalid directory")
       (->> (.listFiles file)
            (map #(.getName ^File %))
            (str/join " ")
            println)))))
