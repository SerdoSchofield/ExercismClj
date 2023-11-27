(ns change)

(defn issue [amount coins] ;; <- arglist goes here
  (let [coins (sort coins)
        values-less-than-amount (range 1 (inc amount))
        change-map (reduce (fn [lowest-combos n]
                  (->> coins
                       (filter #(<= % n))
                       (map #(conj (lowest-combos (- n %) []) %))
                       (apply min-key count)
                       (assoc lowest-combos n)))
                           {} values-less-than-amount)]
    (change-map amount)
    )
)

(issue 23 #{1 4 15 20 50})
