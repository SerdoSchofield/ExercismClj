(ns pangram)

(def a2z
  (let [caps (range (int \A) (inc (int \Z)))]
    (->>
     caps
     (map char)
     set
     (#(conj % \space))
     )))

(defn pangram? [s] ;; <- arglist goes here
  (and
   (->> s
        .toUpperCase
        (remove (partial a2z))
        empty?
        )
   (->> a2z
        (remove (partial (set (.toUpperCase s))))
        empty?
        )
   )
)
