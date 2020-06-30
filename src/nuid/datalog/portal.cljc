(ns nuid.datalog.portal
  (:require
   [nuid.datalog.credential :as credential]))

(def attributes
  [{:db/ident       :nuid.auth-api/api-keys
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/isComponent true
    :db/doc         "Set of [[:nuid.auth-api/api-key]]s"}

   {:db/ident       :nuid.aws.api-gateway.api-key/id
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "An [[:nuid.aws.api-gateway/api-key]] identifier"}

   {:db/ident       :nuid.aws.api-gateway.api-key/value
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "An [[:nuid.aws.api-gateway/api-key]] value"}

   {:db/ident       :nuid/credentials
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/isComponent true
    :db/doc         "Set of [[:nuid/credential]]s"}

   {:db/ident       :nuid.portal.developer/hashed-email-address
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "Pseudonymous identifier derived from an email address"}])

#_
(def org
  [{:db/ident       :nuid.portal/developers
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/isComponent true
    :db/doc         "Set of [[:nuid.portal/developer]]s"}

   {:db/ident       :nuid.portal.org/administrators
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/isComponent true
    :db/doc         "Administrators of a [[:nuid.portal/org]]"}])

(def schema
  (concat
   attributes
   credential/schema))
