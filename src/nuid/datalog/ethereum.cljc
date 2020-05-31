(ns nuid.datalog.ethereum
  (:require
   [nuid.datalog.lib :as lib]
   [nuid.ethereum :as eth]
   [nuid.ethereum.transaction :as tx]))

(def idents
  (mapv lib/->ident eth/networks))

(def attributes
  [{:db/ident       ::tx/id
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "Ethereum transaction identifier"}

   {:db/ident       ::eth/network
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc         "Ethereum network identifier"}])
