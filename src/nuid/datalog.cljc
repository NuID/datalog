(ns nuid.datalog
  (:require
   [nuid.datalog.credential :as credential]
   [nuid.datalog.cryptography :as cryptography]
   [nuid.datalog.elliptic :as elliptic]
   [nuid.datalog.ethereum :as ethereum]))

(def idents
  (concat
   cryptography/hash-algorithm-idents
   cryptography/string-normalization-idents
   elliptic/idents
   ethereum/idents))

(def attributes
  (concat
   credential/attributes
   cryptography/attributes
   elliptic/attributes
   ethereum/attributes))
