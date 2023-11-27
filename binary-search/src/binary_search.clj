(ns binary-search)

(defn middle [col] ;; <- arglist goes here
  (if (empty? col)
    nil
    (int (Math/floor (/ (count col) 2)))))

(defn search-for [x col] ;; <- arglist goes here
  (let [sorted (vec (sort col))
        mid (middle col)]
    (println sorted mid (sorted mid))
    (cond
      (= x (sorted mid)) mid
      (zero? mid) (throw (Exception. "not found"))
      (> x (sorted mid))
      (if-let [res (search-for x (subvec sorted mid))]
        (do
          (println + mid res)
          (+ mid res)))
      (< x (sorted mid)) 
      (if-let [res (search-for x (subvec sorted 0 mid))]
        res))))