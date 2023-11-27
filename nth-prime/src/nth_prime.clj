(ns nth-prime)

(defn get-mults [x lim]
  (for [i (take-while (partial > lim) (iterate (partial + x) (* x x)))]
    i))

(defn sieve! [n mults]
  (->>
   (for [i (range 2 n)
            :let [mults-1 mults]]
        (if-not (@mults-1 i)
          (do
            (swap! mults into (get-mults i n))
            [i mults])))
   (filter some?)
   (map first))
  )

(defn nth-prime [n] ;; <- arglist goes here
  (if-not (pos? n) (IllegalArgumentException.)
          (let [mults (atom #{})]
            (->
             (for [limit (iterate (* 1000 1000) 1000)
                   :let [primes (sieve! limit mults)
                         p-count (count primes)]]
               primes)
             (nth n)
             )
            ;(loop [limit 1000]
            ;  (let [primes (sieve! limit mults)
            ;        p-count (count primes)]
            ;    (if (> n p-count)
            ;      (recur (* limit limit))
            ;      (nth primes (dec n)))))))
            ))
  )
