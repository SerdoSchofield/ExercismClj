(ns wordy)

(def operations-map
  {:plus +
   :minus -
   :multiplied *
   :divided /
   ;;:cubed #(apply * (repeat 3 %))
   :raised #(apply * (repeat %2 %1))
   })

(defn evaluate [query] ;; <- arglist goes here
  (or (-> query
          (clojure.string/replace #"(?i)[^ a-z0-9\-]" "")
          (clojure.string/split #" ")
          (some->>
           (filter #(or ((apply hash-set
                                (map (comp name key) operations-map))
                         %)
                        (re-matches #"-?\d+.*?" %)))
           (partition 3 2)
           (map (juxt (comp operations-map keyword second)
                      (comp #(Integer/parseInt %)
                            #(clojure.string/replace % #"[^0-9\-]" "")
                            first)
                      (comp #(Integer/parseInt %)
                            #(clojure.string/replace % #"[^0-9\-]" "")
                            last)))
           seq
           (reduce #(vector
                     (first %2)
                     (apply (first %1) (rest %1))
                     (last %2)
                     ))
           (#(apply (first %) (rest %)))
           )
          )
      (throw (IllegalArgumentException.)))
)
