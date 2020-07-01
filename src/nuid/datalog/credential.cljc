(ns nuid.datalog.credential
  (:require
   [nuid.datalog.cryptography :as cryptography]
   [nuid.datalog.elliptic :as elliptic]
   [nuid.datalog.ethereum :as ethereum]))

(def attributes
  [{:db/ident       :nuid.credential/addresses
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/isComponent true
    :db/doc         "External storage locations of a credential"}])

(def schema
  (concat
   attributes
   cryptography/idents
   cryptography/attributes
   elliptic/idents
   elliptic/attributes))
