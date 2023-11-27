(ns octal)

(defonce m
  (loop [i 0
         ret {}]
    (cond
      (> i 7) ret
      :else (recur (inc i) (assoc ret (first (str i)) i)))))

(defmacro pow [x n]
  `(reduce * (repeat ~n ~x)))

(defn to-decimal [oct] ;; <- arglist goes here
   (loop [t1 (reverse oct)
         i 0
         res 0]
    (if (empty? t1) res
        (if-let [bit (m (first t1))]
          (let [bit-val (* bit (pow 8 i))]
            (recur (rest t1) (inc i) (+ res bit-val)))
          0)))
)
