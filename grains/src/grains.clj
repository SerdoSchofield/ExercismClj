(ns grains)

(defn square [x] ;; <- arglist goes here
  (.shiftLeft (biginteger 1) (dec x)))

(defn total []  ;; <- arglist goes here
  (loop [i 0
         res (biginteger 0)]
    (if (= i 64)
      res
      (recur (inc i) (.flipBit res i))))
)
