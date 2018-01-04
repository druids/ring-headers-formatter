(ns ring-headers-formatter.core-test
  (:require
    [clojure.test :refer [are deftest testing]]
    [ring-headers-formatter.core :refer [wrap-response-headers]]))


(deftest ring-headers-formatter-test
  (are [expected headers] (= expected (-> #(hash-map :headers %, :body "")
                                          wrap-response-headers
                                          (apply [headers])
                                          :headers))
       {"X-Limit" "100"} {:x-limit 100}
       {} {}
       {} nil
       {"" ""} {nil nil}
       {"X-Limit" "100"} {"X-Limit" "100"}))
