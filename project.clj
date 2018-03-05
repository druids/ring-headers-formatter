(defproject ring-headers-formatter "0.1.2"
  :description "A Ring's middleware converts headers into Title-Case and returns keys/values as strings"
  :url "https://github.com/druids/ring-headers-formatter"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}

  :profiles {:dev {:plugins [[lein-cloverage "1.0.10"]
                             [lein-kibit "0.1.6"]
                             [jonase/eastwood "0.2.5"]]
                   :dependencies [[org.clojure/clojure "1.9.0"]]}})
