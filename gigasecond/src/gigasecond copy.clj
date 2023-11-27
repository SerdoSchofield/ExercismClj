;; (ns gigasecond)

;; (def gigasecond 1000000000)

;; (defn leap-year? [year] ;; <- argslist goes here
;;   (if (< year 4) false
;;       (if (zero? (mod year 4))
;;         (cond
;;           (zero? (mod year 400)) true
;;           (zero? (mod year 100)) false
;;           :default true)
;;         false)))

;; (defn days-to-sec [d] (* d 24 60 60))

;; (defn year-to-sec [y] (* y (days-to-sec (if (leap-year? y) 366 365))))

;; (defn months-elapsed-in-sec
;;   [m y]
;;   (loop [i 1
;;          res 0]
;;     (if (= i m)
;;       (days-to-sec res)
;;       (cond
;;         (not (zero? (mod i 2))) 
;;           (recur (inc i) (+ res 31))
;;         (and (= 2 i) (leap-year? y)) 
;;           (recur (inc i) (+ res 29))
;;         (= 2 i) 
;;           (recur (inc i) (+ res 28))
;;         :else (recur (inc i) (+ res 30))))))

;; (defn secs-to-year [s]
;;   (int (/ s (year-to-sec 1))))

;; (defn secs-to-mon [s]
;;   (int (/ s (months-elapsed-in-sec 2 1))))

;; (defn secs-to-day [s]
;;   (int (/ s (days-to-sec 1))))

;; (defn from [year month day]  ;; <- arglist goes here
;;   (let [s (+ (year-to-sec year)
;;              (months-elapsed-in-sec month year)
;;              (days-to-sec day))
;;         s+ (+ gigasecond s)
;;         s+-year (secs-to-year s+)
;;         s+-mon (inc (secs-to-mon (- s+ (year-to-sec s+-year))))
;;         s+-day (secs-to-day (- s+
;;                                (year-to-sec s+-year)
;;                                (months-elapsed-in-sec s+-mon year)))]
;;     (println s+ s+-year s+-mon s+-day 
;;              (year-to-sec s+-year)
;;              (months-elapsed-in-sec (inc s+-mon) year))))
