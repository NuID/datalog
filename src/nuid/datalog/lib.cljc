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
  "Removes datalog-specific
  keys from nested structure"
  (partial
   walk/postwalk
   -postwalk->data))
