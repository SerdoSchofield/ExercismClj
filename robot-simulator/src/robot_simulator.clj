(ns robot-simulator)

(def directions (cycle [:north
                       :east
                       :south
                       :west]))

(defn robot [coord dir] ;; <- arglist goes here
  {:coordinates coord
   :bearing dir}
)

(defn turn-right [bearing] ;; <- arglist goes here
  (println bearing)
  (->  bearing
       hash-set
       complement
       (drop-while directions)
       second)
)

(defn turn-left [bearing] ;; <- arglist goes here
  (println bearing)
  (-> bearing
      hash-set
      complement
      (drop-while directions)
      (#(take 4 %))
      last)
)

(defn advance [robot]
  (let [[k f] (case (:bearing robot)
             :north [:y inc]
             :east [:x inc]
             :south [:y dec]
             :west [:x dec])]
    (update-in robot [:coordinates k] f))
)

(defn simulate [instructions robot] ;; <- arglist goes here
  (reduce (fn [r instruction]
            (println r instruction)
            (case instruction
              \R (update r :bearing turn-right)
              \L (update r :bearing turn-left)
              \A (advance r)))
          robot
          instructions)
)
