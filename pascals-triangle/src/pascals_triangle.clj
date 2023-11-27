(ns pascals-triangle)

(def triangle
  (iterate
   (fn [prev-row]
     (->> (concat [[(first prev-row)]] (partition 2 1 prev-row) [[(last prev-row)]])
          (map (partial apply +))))
     ;;(map
      ;;#(apply + %)
      ;;(concat [[(first prev-row)]] (partition 2 1 prev-row) [[(last prev-row)]])))
   [1N])
)

(defn row [n] ;; <- arglist goes here
  (->> triangle (take n) last)
)
