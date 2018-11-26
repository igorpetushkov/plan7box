(ns plan7.box.sh.cmd
  ; (:require
  ;   [plan7.box.sys.io :as sys-io]
  ;   )
  (:gen-class))

(declare 
  parse-cmd
  eval-cmd)

(defn cmd
  [line]
  (when (some? (parse-cmd line))
    (eval-cmd line)))

; ~   ~   ~   ~   ~

(defn- parse-cmd
  [line]
  line)

(defn- eval-cmd
  [line]
  (str :process " " line))
