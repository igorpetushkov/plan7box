; (ns plan7.box.config.core
;   (:require
;     [plan7.box.sys.fs :as sys-fs])
;   (:gen-class))

; ; (ns plan7.box.data.core
; ;   (:require
; ;     [plan7.box.data.users :as data-users]
; ;     [plan7.box.data.sessions :as data-sessions]
; ;     [plan7.box.data.fs :as data-fs]
; ;     )
; ;   (:gen-class))

; ; (defmulti get-data keyword)
; ; (defmethod get-data :users [_] (data-users/load-data))
; ; (defmethod get-data :sessions [] (data-sessions/load-data))

; ; (defmulti add-data :key)
; ; (defmethod add-data :users [_] (data-users/add-data))
; ; (defmethod add-data :sessions [_] (data-sessions/add-data))

; ; (defmulti update-data :key)
; ; (defmethod update-data :users [_] (data-users/update-data))
; ; (defmethod update-data :sessions [_] (data-sessions/update-data))

; ; (defmulti remove-data :key)
; ; (defmethod remove-data :users [_] (data-users/remove-data))
; ; (defmethod remove-data :sessions [_] (data-sessions/remove-data))