(ns nuid.datalog.cryptography
  (:require
   [clojure.set :as set]
   [nuid.datalog :as datalog]
   [nuid.ident.cryptography :as ident.crypt]))

(def idents
  (into
   (vector)
   (map datalog/ident)
   (set/union
    ident.crypt/hash-algorithms
    ident.crypt/string-normalization-forms)))

(def attributes
  [{:db/ident       :nuid.cryptography.hash/algorithm
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc         "KDF algorithm identifier"}

   {:db/ident       :nuid.cryptography.base64/salt
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc         "Base64 encoded cryptographically secure random bytes"}

   {:db/ident       :string.normalization/form
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc         "String normalization form"}

   {:db/ident       :nuid.cryptography.hash.algorithm.scrypt/N
    :db/valueType   :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc         "N parameter of SCrypt algorithm"}

   {:db/ident       :nuid.cryptography.hash.algorithm.scrypt/r
    :db/valueType   :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc         "r parameter of SCrypt algorithm"}

   {:db/ident       :nuid.cryptography.hash.algorithm.scrypt/p
    :db/valueType   :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc         "p parameter of SCrypt algorithm"}

   {:db/ident       :nuid.cryptography.hash.algorithm.scrypt/length
    :db/valueType   :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc         "Number of output bytes of SCrypt algorithm"}])
