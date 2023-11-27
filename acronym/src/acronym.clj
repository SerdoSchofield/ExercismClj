(ns acronym)

(defn acronym [s] ;; <- arglist goes here
  (->> s
       (partition-by #{\space \-})
       (filter #(nil? (some #{\space \-} %)))
       (map #(->> % first clojure.string/upper-case))
       (apply str))
)
