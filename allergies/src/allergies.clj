(ns allergies)

(def m {
        2r1 :eggs
        2r10 :peanuts
        2r100 :shellfish
        2r1000 :strawberries
        2r10000 :tomatoes
        2r100000 :chocolate
        2r1000000 :pollen
        2r10000000 :cats
        })

(defn allergies [n] ;; <- arglist goes here
  (loop [m1 m
         ret []]
    (if-let [[k v] (first m1)]
      (if (zero? (bit-and k n))
        (recur (rest m1) ret)
        (recur (rest m1) (conj ret v)))
      ret))
)

(defn allergic-to? [score allergen] ;; <- arglist goes here
  (if (some #{allergen} (allergies score)) true false)
)
