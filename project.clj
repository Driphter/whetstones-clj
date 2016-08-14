(defproject whetstones-clj "0.1.0-SNAPSHOT"
  :description "This is my collection of solutions and associated tests for various
                programming challenges. I call them my whetstones because they're
                supposed to keep my skills sharp. :)"
  :url "https://github.com/Driphter/whetstones-clj"
  :dependencies [[org.clojure/clojure "1.9.0-alpha10"]]
  :global-vars {*warn-on-reflection* true}
  :eastwood {:exclude-linters [:constant-test]}
  :aliases {"omni" ["do"
                    ["clean"]
                    ["with-profile" "production" "deps" ":tree"]
                    ["ancient" "upgrade" ":recursive" ":all" ":allow-snapshots"]
                    ["cljfmt" "fix"]
                    ["eastwood"]
                    ["kibit"]
                    ["bikeshed"]]}
  :plugins [[lein-kibit "0.1.2" :exclusions [org.clojure/clojure]]
            [lein-cljfmt "0.5.3" :exclusions [org.clojure/clojure]]
            [jonase/eastwood "0.2.3"]
            [lein-bikeshed "0.3.0"]])
