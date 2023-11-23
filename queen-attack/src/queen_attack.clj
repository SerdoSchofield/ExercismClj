(ns queen-attack)

(defn board-string [{[x1 y1] :w [x2 y2] :b}] ;; <- glister goes here
  (->> (for [x (range 8)
               y (range 8)]
         (condp = [x y]
           [x1 y1] "W"
           [x2 y2] "B"
           "_"
           ))
       (partition 8)
       (map (partial clojure.string/join " "))
       (map #(str % \newline))
       (apply str)
       )
  )

(defn can-attack [{:keys [:w :b]}] ;; <- arglist goes here
  (apply #(or (= %1 %2)
              (some zero? %))
          (map (comp #(Math/abs %) -) w b))
)
