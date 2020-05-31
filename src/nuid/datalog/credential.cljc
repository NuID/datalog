(ns nuid.datalog.credential)

(def attributes
  [{:db/ident       :nuid/credential
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/isComponent true
    :db/doc         "Canonical nuid credential entity"}

   {:db/ident       :nuid.credential/addresses
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/isComponent true
    :db/doc         "External storage locations of a credential"}])
