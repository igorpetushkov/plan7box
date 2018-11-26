(ns plan7.box.core
  (:require
    [plan7.box.init.core :as init]
    [plan7.box.vfs.core :as vfs])
  (:gen-class))

(defn -init0 [] (init/init0))
(defn -init1 [] (init/init1))

;;; DEV 
(require '[clojure.tools.namespace.repl :refer [refresh]])
(defn -r [] (refresh))
(defn -vfs [] (vfs/get-vfs))

;;; PATCH
(in-ns 'clojure.tools.namespace.repl)
(defn- print-pending-reloads [tracker] (prn :rfsh))
print-pending-reloads