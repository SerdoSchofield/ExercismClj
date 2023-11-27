(ns space-age)

(def secs-per-year (* 60 60 24 365.25))

(defn on-earth [s] ;; <- arglist goes here
  (/ s secs-per-year)
)

(defn on-mercury [s] ;; <- arglist goes here
  (/ (on-earth s) 0.2408467)
)

(defn on-venus [s] ;; <- arglist goes here
  (/ (on-earth s) 0.61519726)
)

(defn on-mars [s] ;; <- arglist goes here
  (/ (on-earth s) 1.8808158)
)

(defn on-jupiter [s] ;; <- arglist goes here
  (/ (on-earth s) 11.862615)
)

(defn on-saturn [s] ;; <- arglist goes here
  (/ (on-earth s) 29.447498)
)

(defn on-uranus [s] ;; <- arglist goes here
  (/ (on-earth s) 84.016846)
)

(defn on-neptune [s] ;; <- arglist goes here
  (/ (on-earth s) 164.79132)
)
