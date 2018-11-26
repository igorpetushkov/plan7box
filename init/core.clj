(ns plan7.box.init.core
  (:require
    [plan7.box.sys.conf :as sys-conf]
    [plan7.box.sys.fs :as sys-fs]
    [plan7.box.sys.io :as sys-io]
    [plan7.box.vfs.core :as vfs]
    [plan7.box.sh.core :as sh]
    )
  (:gen-class))

(declare 
  build-vfs
  build-vfs-empty
  init-vfs
  init-sessions
  init-sh)

(defn init0
  []
  (let [type (sys-conf/load-config :vfs-type)]
    (as-> (build-vfs) vfs
      (cond
        (= type :fs) (sys-fs/write-file (sys-conf/get-vfs-file-path) vfs)
        (= type :mongo) (prn :install-mongo)))))

(defn init1
  []
  (init-vfs)
  (init-sessions)
  (init-sh))

; ~   ~   ~   ~   ~

(defn- build-vfs
  []
  (as-> (build-vfs-empty) vfs
    (update vfs :config 
      #(assoc % :passwords {:root "root"} :groups {:root ["root"]} :sessions nil))
    (update vfs :bin
      #(assoc % :ls "vfs.app.ls"))))

(defn- build-vfs-empty
  []
  (let [template [:config :bin :home :system :lib :temp :games :rd3]]
    (zipmap template 
      (take (count template) (repeatedly (constantly nil))))))

(defn- init-vfs
  []
  (cond
    (sys-conf/vfs-memory?) (vfs/set-vfs (vfs/load-vfs-file))
    ; (sys-conf/vfs-fs?) (prn :TODO-check-file)
    (sys-conf/vfs-mongo?) (prn :init-vfs-mongo)))

(defn- init-sessions
  []
  (when (nil? (vfs/get-in-vfs [:config :sessions]))
    (as-> (sys-fs/read-file (sys-conf/get-sessions-file-path) :clj) s
      (when (some? s) (vfs/update-in-vfs [:config :sessions] s)))))

(defn- init-sh
  []
    (as-> (vfs/get-in-vfs [:config :sessions :local]) local-session
      (if (some? local-session)
        (sh/login (first local-session))
        (let [login (sys-io/ask-input "login: ")]
              ; password (sys-io/ask-input "password: ")]
          (sh/login login)))))