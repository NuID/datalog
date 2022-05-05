(ns nuid.datalog.elliptic
  (:require
   [nuid.datalog :as datalog]
   [nuid.ident.elliptic :as ident.elliptic]))

(def idents
  (into
   (vector)
   (map datalog/ident)
   ident.elliptic/curve-ids))

(def attributes
  [{:db/ident       :nuid.elliptic.curve/id
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc         "Elliptic curve identifier"}

   {:db/ident       :nuid.elliptic.curve/parameters
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/isComponent true
    :db/doc         "Elliptic curve parameters"}

   {:db/ident       :nuid.elliptic.curve/point
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "Encoded elliptic curve point"}])
