(ns binary)

(defmacro pow [x n]
  `(reduce * (repeat ~n ~x)))

(defn to-decimal [bin] ;; <- arglist goes here
  (loop [b1 (reverse bin)
         i 0
         res 0]
    (if (empty? b1) res
        (let [bit (case (first b1) \0 0 \1 1 0)
              bit-val (* bit (pow 2 i))]
            (recur (rest b1) (inc i) (+ res bit-val)))))
)

(defonce dig-map
  (let [r (range 10)]
    (-> (map #(-> % str first) r)
        (zipmap r))))

(defn to-decimal2 [bin]
  (let [bin-to-dec
        (for [[i dig] (into {} (map-indexed hash-map bin))
              :let [j (- (count bin) i 1)]]
          (when (>= i 0)
            (if-let [bit (dig-map dig)]
              (* bit (pow 9 j))
              0)))]
    (apply + bin-to-dec))
)
