(ns nuid.datalog
  (:require
   [clojure.walk :as walk]))


   ;;;
   ;;; NOTE: helper functions, internal logic
   ;;;


(def ident
  (partial hash-map :db/ident))

(defn postwalk-format-ident
  [x]
  (or
   (and
    (map? x)
    (:db/ident x))
   x))

(defn postwalk-format-data
  [x]
  (or
   (and
    (map? x)
    (:db/ident x))
   (and
    (map? x)
    (dissoc x :db/id :db/ensure))
   x))


   ;;;
   ;;; NOTE: api
   ;;;


(def format-idents
  (partial walk/postwalk postwalk-format-ident))

(def format-data
  (partial walk/postwalk postwalk-format-data))
