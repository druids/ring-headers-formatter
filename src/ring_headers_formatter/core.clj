(ns ring-headers-formatter.core
  (:require
    [clojure.string :refer [capitalize join split]]))


(defn- format-key
  [key-name]
  (if (nil? key-name)
    ""
    (->> (split (name key-name) #"-") (map capitalize) (join "-"))))


(defn- format-headers
  [headers]
  (reduce-kv #(assoc %1 (format-key %2) (str %3)) {} headers))


(defn wrap-response-headers
  "Middleware that converts response's headers into Title-Case and make sure that keys and values are strings."
  [handler]
  (fn [request]
    (update (handler request) :headers format-headers)))
