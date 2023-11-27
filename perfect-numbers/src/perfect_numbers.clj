(ns perfect-numbers)

(defn factors [x]
  (loop [i 2
         res [1]]
    (if (= x i) 
      res
      (if (zero? (mod x i))
        (recur (inc i) (conj res i))
        (recur (inc i) res)))))

(defn classify [x] ;; <- arglist goes here
  (if (neg-int? x) (throw (IllegalArgumentException. "shame on you")))
  (let [sum (apply + (factors x))]
    (cond
      (> sum x) :abundant
      (= sum x) :perfect
      (< sum x) :deficient)))
