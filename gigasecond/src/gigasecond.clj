(ns gigasecond)

(def gigasecond 1000000000)
(def secs-in-day (* 24 60 60))
(def days-in-gigasec (/ gigasecond secs-in-day))
(defn leap-year? [year] ;; <- argslist goes here
  (if (< year 4) false
      (if (zero? (mod year 4))
        (cond 
          (zero? (mod year 400)) true
          (zero? (mod year 100)) false
          :default true)
        false))
)


(defn days-in-month [m y]
  (cond
    (not (zero? (mod m 2))) 31
    (and (= 2 m) (leap-year? y)) 29
    :else 28))

(defn secs-to-days [s] (int (/ s )))

(defn from [year month day]  ;; <- arglist goes here
  (loop [i days-in-gigasec
         y year
         m month
         d day]
      ;; 2021 1 1
    (cond
      (zero? i) (println y m d)
      (> m 12)
        (recur i (inc y) 1 d)
      (> d (days-in-month m y))
        (recur i y (inc m) 1)
      :else
        (recur (dec i) y m (inc d)))))
