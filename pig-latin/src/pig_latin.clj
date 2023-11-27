(ns pig-latin)

(def vowel #{\a \e \i \o \u})

(defn translate [sentence] ;; <- arglist goes here
  (->> (for [word-array (partition-by #{\space} sentence)
            :let [s (apply str word-array)]]
        (cond
          (= " " s) s
          (or (vowel (first s))
              (#{"xr" "yt"} (apply str (take 2 s)))) (str s "ay")
          :default (let [initial-consonants (apply str (take-while #(not (vowel %)) s))
                         cons-count (count initial-consonants)]
                     (cond
                       (and (> cons-count 1) (= \y (last initial-consonants)))
                       (apply str
                              (flatten
                               [(drop (dec cons-count) s)
                                (drop-last initial-consonants)
                                "ay"]))
                       (and (= \q (last initial-consonants)) (= \u (nth s cons-count)))
                       (apply str
                              (flatten
                               [(drop (inc cons-count) s)
                                initial-consonants
                                \u
                                "ay"]))
                       :default
                       (apply str
                              (flatten
                               [(drop cons-count s)
                                initial-consonants
                                "ay"]))
                       ))))
      (apply str)
      )
)
