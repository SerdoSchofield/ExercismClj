(ns strain)

(defn clean [coll]
  (loop [c coll
         ret []]
    (if (empty? c) ret
        (if-let [x (first c)]
          (recur (rest c) (conj ret x))
          (recur (rest c) ret)))))

(defn retain [f coll] ;; <- arglist goes here
  (->> coll
      (map #(when (f %) %))
      clean)
)

(defn discard [f coll] ;; <- arglist goes here
  (clean (map #(if-not (f %) %) coll));; your code goes here
)
