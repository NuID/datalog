(ns nuid.datalog.portal
  (:require
   [nuid.datalog.credential :as credential]
   [nuid.datalog.paypal :as paypal]))

(def notification-template-enums
  [{:db/ident :nuid.portal.email/credential-lost}
   {:db/ident :nuid.portal.email/credential-rotated}
   {:db/ident :nuid.portal.email/email-address-rotated}
   {:db/ident :nuid.portal.email/verify-email-address}])

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
    :db/doc         "Pseudonymous identifier derived from an [[:email-address]]"}

   {:db/ident       :nuid.portal.email-address/verified?
    :db/valueType   :db.type/boolean
    :db/cardinality :db.cardinality/one
    :db/doc         "Describes if the [[:email-address]] has been verified or not"}

   {:db/ident       :nuid.portal.email/ident
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc         "Ref to the email ident for this notification"}

   {:db/ident       :nuid.portal.email/hash-key
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "Hash of relevant template data to uniquely identify the email send"}

   {:db/ident       :nuid.portal.email/sent-inst
    :db/valueType   :db.type/instant
    :db/cardinality :db.cardinality/one
    :db/doc         "Instant for when the email was sent"}

   {:db/ident       :nuid.portal/notifications
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/doc         "Records of notifications sent"}

   {:db/ident       :nuid.portal.notification/addresses
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/doc         "List of notification addresses"}

   {:db/ident       :nuid.portal/subscriptions
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/doc         "Set of [[:nuid.portal/subscription]]s"}])

(def schema
  (concat
   notification-template-enums
   attributes
   paypal/attributes
   credential/schema))
