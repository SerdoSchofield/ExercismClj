(ns test)

(def triangle
  (iterate
    (fn [prev-row]
      (let [x (concat [[(first prev-row)]] (partition 2 1 prev-row) [[(last prev-row)]])]
        (map (partial reduce +) x)))
    [1N])
)

(take 3 triangle)

(defn sum-of-multiples-TOO-LONG [n a b]
  (if (and (< n a) (< n b)) 0
      (->> (range 1 n)
           (map
            #(->>  [a b]
                   (map (partial mod %))
                   ((fn get-mod-zero [x] (when (some zero? x) %)))
                   ))
           (remove nil?)
           (reduce +)
           )))

(defn sum-of-multiples-3 [n a b]
  (if-let [lowest (cond
                 (and (< n a) (< n b)) nil
                 (< a b) a
                 (> b a) b
                 :else a)]
    (let [as (take-while (partial > n) (iterate (partial + a) a))
          bs (take-while (partial > n) (iterate (partial + b) b))
          ]
      (->> (concat as bs)
           distinct
           (reduce +)))
    0)
)

(defn som [n a b]
  (- (+ (take-while (partial > n) (iterate (partial + (* a b)) (* a b)))
        (take-while (partial > n) (iterate (partial + a) a))
        (take-while (partial > n) (iterate (partial + b) b)))))

(defn sum-of-multiples [n a b]
  (- (apply - (for [d [(* a b) a b]
                    :let [m (quot (- n 1) d)]]
                (*' d m (+ m 1) 1/2)))))

(sum-of-multiples 5 2 4)
