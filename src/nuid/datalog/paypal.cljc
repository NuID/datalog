(ns nuid.datalog.paypal)

(def attributes
  [{:db/ident       :paypal/plan_id
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "`plan_id` as returned from the PayPal API"}

   {:db/ident       :paypal/plan
    :db/valueType   :db.type/ref
    :db/cardinality :db.cardinality/one
    :db/doc         "Any entity that maps to plan data as retruned from the PayPal API"}

   {:db/ident       :paypal/subscription_id
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity
    :db/doc         "`subscription_id` as returned from the PayPal API"}])
