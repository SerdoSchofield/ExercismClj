(ns luhn)

(defn valid? [payload] ;; <- arglist goes here
  (if (re-find #"[^ \d]" payload) false
    (let [[check payload] (-> payload
                              reverse
                              (->> (remove #{\space})
                                   (map #(Integer/parseInt (str %))))
                              ((juxt first rest)))
          [singles doubles] (->> payload
                                 (map-indexed (comp first hash-map))
                                 (group-by (comp odd? key))
                                 ((juxt #(get % true) #(get % false)))
                                 (map (partial map last))
                                 )
          luhned (when (seq doubles)
                   (->> doubles
                        (map (partial * 2))
                        (apply conj singles)
                        (apply str)
                        (map #(Integer/parseInt (str %)))
                        (apply +)
                        (#(mod (- 10 (mod % 10)) 10))))]
      (= check luhned)))
)
