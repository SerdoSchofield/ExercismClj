(ns sieve)

(defn sieve [lim] ;; <- arglist goes here
  (->
   (loop [i 2
          not-prime #{}]
     (cond
       (> i lim) (do (println not-prime) not-prime)
       (contains? not-prime i) (recur (inc i) not-prime)
       :else (recur (inc i) (set (concat not-prime (take-while (partial >= lim) (iterate (partial * i) (* 2 i)))))))
     )
   (remove (range 2 (inc lim))))
)
