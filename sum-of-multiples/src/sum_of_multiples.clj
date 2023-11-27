(ns sum-of-multiples)

(defn sum-of-multiples [[& factors] lim] ;; <- arglist goes here
  (->> factors
   (map
    (fn [f]
      (take-while #(> lim %) (iterate #(+ f %) f)))
    ,,,)
   flatten
   distinct
   (reduce +))
)
