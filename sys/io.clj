(ns plan7.box.sys.io
  (:gen-class))

(defn ask-input
  [& [before-text]]
  (when before-text
    (print before-text)
    (flush))
  (read-line))

(defn ask-input-yn
  [& [before-text]]
  (= (ask-input (str before-text " [y/n] ")) "y"))

; (defn do-print
;   [msg]
;   (print msg))

; (defn do-println
;   [msg]
;   (println msg))


; (defn- format-it
;   [it & [type]]
;   (case type
;     :notify (str :notify " " it)
;     :success (str :success " " it)
;     :error (str :error " " it)
;     (str it)))

; (defn print-it
;   [it]
;   (sys-io/do-print it))

; (defn println-it
;   [it & [type]]
;   (sys-io/do-println (format-it it type)))

; (defn notify-it
;   [it]
;   (println-it it :notify))

; (defn success-it
;   [it]
;   (println-it it :success))

; (defn error-it
;   [it]
;   (println-it it :error))
