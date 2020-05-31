(ns nuid.datalog.cryptography
  (:require
   [nuid.cryptography.base64 :as crypt.base64]
   [nuid.cryptography.hash :as hash]
   [nuid.cryptography.hash.algorithm :as hash.alg]
   [nuid.cryptography.hash.algorithm.scrypt :as scrypt]
   [nuid.cryptography.hash.lib :as hash.lib]
   [nuid.datalog.lib :as lib]))

(def hash-algorithm-idents
  (mapv lib/->ident hash.alg/algorithms))

(def string-normalization-idents
  (mapv lib/->ident hash.lib/string-normalization-forms))

(def attributes
  [{:db/ident       ::hash/algorithm
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc         "KDF algorithm identifier"}

   {:db/ident       ::crypt.base64/salt
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc         "Base64 encoded cryptographically secure random bytes"}

   {:db/ident       :string.normalization/form
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc         "String normalization form [NFC | NFD | NFKC | NFKD]"}

   {:db/ident       ::scrypt/N
    :db/valueType   :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc         "N parameter of SCrypt algorithm"}

   {:db/ident       ::scrypt/r
    :db/valueType   :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc         "r parameter of SCrypt algorithm"}

   {:db/ident       ::scrypt/p
    :db/valueType   :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc         "p parameter of SCrypt algorithm"}

   {:db/ident       ::scrypt/length
    :db/valueType   :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc         "Number of output bytes of SCrypt algorithm"}])
