(ns plan7.box.auth.core
  (:require
    [plan7.box.vfs.core :as vfs])
  (:gen-class))

(defn auth
  [user password]
  (list user "token1"))


; (defn can-read
;   []
;   (prn "can-read"))

; (defn can-write
;   []
;   (prn "can-write"))


; (defn get-token
;   [user sessions]
;   (prn "get-token"))

; (defn load-token
;   [user]
;   (prn "load-token"))

; (defn write-token
;   [user]
;   (prn "load-token"))

; (defn generate-token
;   []
;   (prn "generate-token"))