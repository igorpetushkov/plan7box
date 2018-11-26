(ns plan7.box.vfs.core
  (:require
    [plan7.box.sys.conf :as sys-conf]
    [plan7.box.sys.fs :as sys-fs]
    ; [plan7.box.loader.core :as loader]
    ; [plan7.box.install.core :as install]
    )
  (:gen-class))

(def ^:private vfs-tree (atom nil))

(defn load-vfs-file
  []
  (sys-fs/read-file (sys-conf/get-vfs-file-path) :clj))

(defn get-vfs
  []
  (cond
    (sys-conf/vfs-fs?) (load-vfs-file)
    (sys-conf/vfs-memory?) @vfs-tree))

(defn get-in-vfs
  [path]
  (when (some? path)
    (cond
      (or (sys-conf/vfs-fs?) (sys-conf/vfs-memory?)) (get-in (get-vfs) path)
      (sys-conf/vfs-mongo?) (prn :get-in-vfs-mongo))))

(defn set-vfs
  [data]
  (when (some? data)
    (cond
      (sys-conf/vfs-fs?) (sys-fs/write-file (sys-conf/get-vfs-file-path) data)
      (sys-conf/vfs-memory?) (reset! vfs-tree data))))

(defn update-in-vfs
  [path data]
  (when (and path data)
    (cond
      (or (sys-conf/vfs-fs?) (sys-conf/vfs-memory?))
        (as-> (get-vfs) vfs
          (update-in vfs (pop path) #(assoc % (last path) data))
          (set-vfs vfs))
      (sys-conf/vfs-mongo?) (prn :update-in-vfs-mongo))))

; ~   ~   ~   ~   ~


; (defn load-local-sessions
;   []
;   (config/load-local-session))

; (defn find-in
;   [& keys]
;   (when (not-empty keys) (get-in (get-vfs) keys)))