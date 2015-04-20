(ns whetstones-clj.utils)

(defmacro def- [item value]
  `(def ^{:private true} ~item ~value))
