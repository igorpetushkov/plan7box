(ns plan7.box.auth.utils
  (:gen-class))

(defn build-user-home-template
  []
  (hash-map 
      :.shrc {:pwd "~"}))
  