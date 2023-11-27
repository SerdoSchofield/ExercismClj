(ns scrabble-score)


(defn invert-map [m]
  (->> m
       (mapcat (fn [[k v]]
                 (map #(hash-map % k) v)))
       (into {}))
)

(defn score-letter [l] ;; <- arglist goes here
  (let [s_dict (invert-map {1 [\A \E \I \O \U \L \N \R \S \T]
                            2 [\D \G]
                            3 [\B \C \M \P]
                            4 [\F \H \V \W \Y]
                            5 [\K]
                            8 [\J \X]
                            10 [\Q \Z]})]
    (if-let [v (s_dict l)] v 0)
))

(defn score-word [word] ;; <- arglist goes here
  (->> word
       (map score-letter)
       (reduce +))
)
