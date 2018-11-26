(ns plan7.box.sh.core
  (:require
    [plan7.box.sys.io :as sys-io]
    [plan7.box.vfs.core :as vfs]
    [plan7.box.sh.cmd :as sh-cmd]
    [plan7.box.auth.utils :as auth-utils]
    )
  (:gen-class))

(declare prompt prompt-recur init-user-home)

(defn login
  [name]
  (when (nil? (vfs/get-in-vfs [:home (keyword name)]))
    (init-user-home name (auth-utils/build-user-home-template)))
  (prompt name))

; ~   ~   ~   ~   ~

; (defn- )

(defn- prompt
  [name]
  (prompt-recur name "~/prom/test/it/23"))

(defn- prompt-recur
  [login pwd]
  (sh-cmd/cmd (sys-io/ask-input (str login ": " pwd " # " ))))
  ; (recur login pwd))

(defn- init-user-home
  [user home-template]
  (vfs/update-in-vfs [:home (keyword user)] home-template))
