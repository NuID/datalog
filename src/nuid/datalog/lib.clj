(ns nuid.datalog.lib
  (:require
   [clojure.walk :as walk]))

(def ->ident
  (partial hash-map :db/ident))

(defn -postwalk->data
  [x]
  (or
   (and
    (map? x)
    (:db/ident x))
   (and
    (map? x)
    (dissoc x :db/id :db/ensure))
   x))

(def ->data
  (partial
   walk/postwalk
   -postwalk->data))
