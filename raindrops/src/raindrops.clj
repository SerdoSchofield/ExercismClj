(ns raindrops)

(defn of [n]
  (loop [x n
         i 2
         ret []]
    (cond
      (< x i) ret
      (zero? (mod x i)) (recur (/ x i) i (conj ret i))
      :else (recur x (inc i) ret))))

(defn convert [n] ;; <- arglist goes here
  (loop [s (distinct (of n))
         ret ""]
    (let [s1 (first s)
          s-rest (rest s)]
      (case s1
        nil (if (empty? ret) (str n) ret)
        3 (recur s-rest (str ret "Pling"))
        5 (recur s-rest (str ret "Plang"))
        7 (recur s-rest (str ret "Plong"))
        (recur s-rest ret)))))

(def m {
        3 "Pling"
        5 "Plang"
        7 "Plong"
        })

(defn convert2 [n]
  (let [ret (apply str (map #(m %) (distinct (of n))))]
    (if (empty? ret) (str n) ret)))
