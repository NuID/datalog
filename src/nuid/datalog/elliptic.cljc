(ns nuid.datalog.elliptic
  (:require
   [nuid.datalog.lib :as lib]
   [nuid.elliptic.curve :as curve]))

(def idents
  (mapv lib/->ident curve/ids))

(def attributes
  [{:db/ident       ::curve/point
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "Encoded elliptic curve point"}

   {:db/ident       ::curve/parameters
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/isComponent true
    :db/doc         "Elliptic curve parameters"}

   {:db/ident       ::curve/id
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc         "Elliptic curve identifier"}])
