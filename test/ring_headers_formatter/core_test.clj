(ns ring-headers-formatter.core-test
  (:require
    [clojure.test :refer [are deftest is testing]]
    [ring-headers-formatter.core :refer [wrap-response-headers]]))


(deftest ring-headers-formatter-test
  (testing "should convert response's headers"
    (are [expected headers] (= expected (-> #(hash-map :headers %, :body "")
                                            wrap-response-headers
                                            (apply [headers])
                                            :headers))
         {"X-Limit" "100"} {:x-limit 100}
         {} {}
         {} nil
         {"" ""} {nil nil}
         {"X-Limit" "100"} {"X-Limit" "100"}))

  (testing "should skip lazy seqs"
    (let [lazy (filter even? [0 1 2 3 4])
          headers (-> #(hash-map :headers %, :body "")
                      wrap-response-headers
                      (apply [{:x-lazy lazy, :x-limit 100}])
                      :headers)]
      (is (= {"X-Lazy" lazy, "X-Limit" "100"} headers)))))
