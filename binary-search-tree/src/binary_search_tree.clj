(ns binary-search-tree)

(defn value [s] ;; <- arglist goes here
  (:data s)
)

(defn singleton [n] ;; <- arglist goes here
  {:data n
   :left nil
   :right nil}
)

(defn insert [n s] ;; <- arglist goes here
  (println s)
  (cond (< n (value s))
        (if (:left s)
          (assoc s :left (insert n (:left s)))
          (assoc s :left (singleton n)))
        (> n (value s))
        (if (:right s)
          (assoc s :right (insert n (:right s)))
          (assoc s :right (singleton n)))
        :else s)
 )



(defn left [s] ;; <- arglist goes here
  (:left s)
)

(defn leftmost [s]
  (let [l (left s)]
    (if l (leftmost l) s))
)

(defn right [s] ;; <- arglist goes here
  (:right s)
)

(defn to-list [s] ;; <- arglist goes here
  (d)
)

(defn from-list [args] ;; <- arglist goes here
  (loop [ns args
         s nil]
    (if (empty? ns)
      s
      (if s
        (recur (rest ns) (insert (first ns) s))
        (recur (rest ns) (singleton (first ns))))))
)
