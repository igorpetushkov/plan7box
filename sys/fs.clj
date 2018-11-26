(ns plan7.box.sys.fs
  (:require 
    [clojure.java.io :as -io])
  (:gen-class))

(defn is-exist?
  [path]
  (.exists (-io/as-file path)))

(defn read-file
  [path & [type]]
    (as-> (when (is-exist? path)(slurp path)) f
      (when f
        (cond 
          (= type :clj) (read-string f)
          :else f))))
      
(defn write-file
  [path data]
  (spit path data))
