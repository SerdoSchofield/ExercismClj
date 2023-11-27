(ns hexadecimal)

(def hex-map
  (let [hex 16]
    (into {}
          (for [i (range 0 hex)
                :let [j (cond
                  (> i 9) (-> (- i 10)
                              (+ (int \a))
                              char)
                  :else (-> i str first))]
                ]
            [j i])))
)

(defn pow [x n]
  (apply * (repeat n x)))

(defn hex-to-int [hex] ;; <- arglist goes here
  (->> hex
       reverse
       (map-indexed vector)
       (map (fn [[i c]]
              (* (pow 16 i) (hex-map c))))
       (apply +))
)
