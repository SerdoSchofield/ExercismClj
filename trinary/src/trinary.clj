(ns trinary)

(defmacro pow [x n]
  `(reduce * (repeat ~n ~x)))

(defn to-decimal [trin] ;; <- arglist goes here
   (loop [t1 (reverse trin)
         i 0
         res 0]
    (if (empty? t1) res
        (let [bit (case (first t1) \0 0 \1 1 \2 2 (Exception.))
              bit-val (if (instance? Exception bit) 0 (* bit (pow 3 i)))]
          (if (instance? Exception bit) 0
              (recur (rest t1) (inc i) (+ res bit-val))))))
)
