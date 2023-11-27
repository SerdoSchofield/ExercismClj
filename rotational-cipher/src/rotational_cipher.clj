(ns rotational-cipher)

(defn generate-alphabet [start end]
  (for [c (map char (range (int start) (inc (int end))))] c))

(def upper-case (generate-alphabet \A \Z))

(def lower-case (generate-alphabet \a \z))

(defn rotate [s n] ;; <- arglist goes here
  (->> (for [c s
             :let [l-index (.indexOf lower-case c)
                   u-index (.indexOf upper-case c)]]
         (cond
           (<= 0 l-index) (nth lower-case (mod (+ l-index n) 26))
           (<= 0 u-index) (nth upper-case (mod (+ u-index n) 26))
           :default c))
       (apply str))
)
