(ns diamond)

(def A-int (int \A))

(defn range-mirror
  ([floor i] (range-mirror false floor i))
  ([rev floor i]
     (->> i
          inc
          (range floor)
          (#(if rev (reverse %) %))
          (#(reduce conj % %))
          dedupe
          ))
)

(defn diamond [c] ;; <- arglist goes here
  (let [table (->> c
             int
             (range-mirror (int \A))
             (map char)
             (repeat (inc (* 2 (- (int c) (int \A))))))
        row-order (range-mirror true (int \A) (int c))]
    (->> row-order
         (map (fn [row key]
                (map #(if (= % (char key)) % \space) row))
              table)
        (map (partial apply str))
         )
    )
)
