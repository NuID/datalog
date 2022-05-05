(ns nuid.datalog.portal
  (:require
   [nuid.datalog.credential :as credential]))

(def attributes
  [{:db/ident       :nuid.auth-api/api-key
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/isComponent true
    :db/doc         "The [[:nuid.auth-api/api-key]] entity for accessing the Auth API"}

   {:db/ident       :nuid.auth-api.api-key/value
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "API key value granting access to the Auth API"}

   {:db/ident       :nuid/credential
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/isComponent true
    :db/doc         "The [[:nuid/credential]] authenticating a portal developer"}

   {:db/ident       :nuid.portal/email-address
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "An [[:nuid.portal/email-address]] associated with a portal developer account"}

   {:db/ident       :nuid.portal.developer/verified?
    :db/valueType   :db.type/boolean
    :db/cardinality :db.cardinality/one
    :db/doc         "Describes if the [[:nuid.portal/email-address]] has been verified or not"}])

(def schema
  (concat
   attributes
   credential/schema))
