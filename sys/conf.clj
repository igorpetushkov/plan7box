(ns plan7.box.sys.conf
  (:require 
    [plan7.box.sys.fs :as sys-fs])
  (:gen-class))

(def box-config-path "box.clj")
(def vfs-file-name "vfs")
(def session-file-name "sessions")

(defn load-config
  [& [key]]
  (as-> (sys-fs/read-file box-config-path) f
    (when f (read-string f))
    (if (some? (and key f)) (key f) f)))

(defn get-vfs-file-path
  []
  (format "%s/%s" (load-config :box-path) vfs-file-name))

(defn get-sessions-file-path
  []
  (format "%s/%s" (load-config :box-path) session-file-name))

(defn vfs-fs? 
  []
  (= (load-config :vfs-type) :fs))

(defn vfs-memory? 
  []
  (= (load-config :vfs-type) :memory))

(defn vfs-fs-memory? 
  []
  (= (load-config :vfs-type) :file-memory))

(defn vfs-mongo? 
  []
  (= (load-config :vfs-type) :mongo))

(defn vfs-mongo-memory? 
  []
  (= (load-config :vfs-type) :mongo-memory))
