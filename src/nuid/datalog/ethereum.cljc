(ns nuid.datalog.ethereum
  (:require
   [nuid.datalog :as datalog]
   [nuid.ident.ethereum :as ident.ethereum]))

(def idents
  (into
   (vector)
   (map datalog/ident)
   ident.ethereum/networks))

(def attributes
  [{:db/ident       :nuid.ethereum/network
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc         "Ethereum network identifier"}

   {:db/ident       :nuid.ethereum.transaction/id
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "Ethereum transaction identifier"}])
