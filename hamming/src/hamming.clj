(ns hamming)

(defn distance [strand1 strand2] ; <- arglist goes here
  (cond
    (not (= (count strand1) (count strand2))) nil
    :else
    (->> (interleave strand1 strand2)
         (partition 2)
         (map (fn [[s1 s2]] (= s1 s2)))
         (filter false?)
         count))
)
