(ns grade-school)

(defn grade [school grade]  ;; <- arglist goes here
  (school grade [])
)

(defn add [school name grade]  ;; <- arglist goes here
  (assoc school grade (conj (school grade []) name))
)

(defn sorted [school]  ;; <- arglist goes here
  (->> school
       (map (fn [[k v]] [k (sort v)]))
       (into (sorted-map))
       )
)
