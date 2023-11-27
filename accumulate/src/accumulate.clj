(ns accumulate)

(defn accumulate [f col]
  (for [x col
        :let [y (f x)]]
    y)
)
