(ns difference-of-squares)

(defn sum-of-squares [n] ;; <- arglist goes here
  (->> (range (inc n))
       (map (comp (partial apply *)
                  (partial repeat 2)))
       (apply +))
)

(defn square-of-sum [n] ;; <- arglist goes here
  (->> n
       inc
       range
       (apply +)
       (repeat 2)
       (apply *))
)

(defn difference [n] ;; <- arglist goes here
  (- (square-of-sum n) (sum-of-squares n))
)
