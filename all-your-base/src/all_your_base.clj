(ns all-your-base)

(defmacro pow [x n]
  `(apply * (repeat ~n ~x)))

(defn permitted-bases? [& bases]
  (->> bases
       (map
        #(and (some? %) (> % 1)))
       (some false?)
       not)
)

(defn to-decimal [base n]
  (let [n1 (cond
             (number? n) (map #(Integer/parseInt (str %)) (str n))
             (seq? n) n
             :else nil)]
    (cond (nil? n1) nil
          (not (permitted-bases? base)) nil
          :else
          (->> (for [[index digit] (->> (reverse n1)
                                        (map-indexed hash-map)
                                        (into {}))
                     :let [multiplier (pow base index)]]
                 (* digit multiplier))
               (apply +))))
)

(defn to-base [base n]
  (let [n1 (cond
             (number? n) (map #(Integer/parseInt (str %)) (str n))
             (seq? n) n
             :else nil)]
    (cond (nil? n1) nil
          (not (permitted-bases? base)) nil
          :else
          (->> n
               ((fn [n1] (for [d (take-while (partial < 0) (iterate #(quot % base) n1))
                               :let [r (mod d base)]]
                           r)))
               (#(if (empty? %) '(0) %))
               reverse)))
)

(defn convert [b1 n b2] ;; <- arglist goes here
  (cond
    (not (permitted-bases? b1 b2)) nil
    (some neg? n)             nil
    (some (partial <= b1) n)  nil
    (empty? n)                n
    :default
    (->> n
         (to-decimal b1)
         (to-base b2)))
)
