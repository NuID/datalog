(ns nuid.datalog.auth-api
  (:require
   [nuid.datalog.credential :as credential]
   [nuid.datalog.ethereum :as ethereum]))

(def schema
  (concat
   credential/schema
   ethereum/idents
   ethereum/attributes))
