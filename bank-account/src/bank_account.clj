(ns bank-account)

(def accounts (atom {}))

(def account-id (atom -1))

(defn open-account [] ;; <- arglist goes here
  (let [aid (swap! account-id inc)]
    (swap! accounts assoc aid 0)
    aid)
)

(defn close-account [acc] ;; <- arglist goes here
  (swap! accounts assoc acc nil)
)

(defn get-balance [acc] ;; <- arglist goes here
  (@accounts acc)
)

(defn update-balance [acc bdiff] ;; <- arglist goes here
  (if-let [account (@accounts acc)]
    (let [new-bal (+ account bdiff)]
      (if (neg-int? new-bal) (swap! accounts assoc acc 0) (swap! accounts assoc acc new-bal))))
)
