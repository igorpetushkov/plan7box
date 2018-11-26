; (ns plan7.box.app.print
;   (:gen-class))

; (defn- do-print
;   ([text] (pr text))
;   ([data format] (do-print (format data))))

; (defn >>
;   [& args]
;   (prn args)
;   (apply do-print args))

; (defn >ln
;   [& args]
;   (do (apply >> args) (prn)))

; (defn >notify
;   [& args]
;   ; (>> :notify)
;   (>ln args))