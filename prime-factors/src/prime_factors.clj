(ns prime-factors)

(defn of [n] ;; <- arglist goes here
  (loop [x n
         i 2
         ret []]
    ;(println x i ret)
    (cond
      (> i x) ret
      (zero? (mod x i)) (recur (/ x i) i (conj ret i))
      :else (recur x (inc i) ret)))
)
