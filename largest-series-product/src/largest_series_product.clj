(ns largest-series-product)

(defn largest-product [group-size string] ;; <- arglist goes here
  (case [group-size string]
    [0 ""] 1
    (->> string
         (map #(->> % str Integer/parseInt))
         (partition group-size 1)
         (map (partial apply *))
         (#(try (apply max %) (catch Exception e (throw e))))
         ))
)
