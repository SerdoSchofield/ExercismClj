(ns poker)

(def card-order ["A" "1" "2" "3" "4" "5" "6" "7" "8" "9" "10" "J" "Q" "K"])

(defn get-vals [hand]
  (map (comp (partial apply str) pop vec) hand))

(defn n-of-a-kind [n hand]
  (= (- 6 n) (count (distinct (get-vals hand)))))

(defn straight [hand]
  (let [values (get-vals hand)
        sorted-values (sort-by #(.indexOf card-order %) values)]
    (->> sorted-values
         (partition 2 1)
         (map #(= (inc (.indexOf card-order (first %)))
                  (.indexOf card-order (last %))))
         (apply (partial = true)))
    )
  )

(defn is-flush [hand]
  (apply = (map last hand)))

(defn straight-flush [hand]
  (and (straight hand) flush))

(defn full-house [hand]
  (let [freqs (frequencies (get-vals hand))]
    (and (= (count freqs) 2)
         (->> freqs
             (map val)
             sort
             (= [2 3]))))
  )

(defn n-pairs [n hand]
  (= n (get (->> hand
                 get-vals
                 frequencies
                 (map val)
                 frequencies)
            2)))

(defn score-hand [hand score]
  {:hand hand :score score})

(defn best-hands [hands] ;; <- arglist goes here
  (let [hands (map #(clojure.string/split % #" ") hands)]
    (->> (map #(cond
               (n-of-a-kind 5 %) (score-hand % 10)
               (straight-flush %) (score-hand % 9)
               (n-of-a-kind 4 %) (score-hand % 8)
               (full-house %) (score-hand % 7)
               (is-flush %) (score-hand % 6)
               (straight %) (score-hand % 5)
               (n-of-a-kind 3 %) (score-hand % 4)
               (n-pairs 2 %) (score-hand % 3)
               (n-pairs 1 %) (score-hand % 2)
               :else (score-hand % 1))
             hands)
         (sort-by :score)
         ((fn [hs] (take-while #(= (-> hs first :score) (:score %)) hs)))))
  )
