(ns leap)

(defn leap-year? [year] ;; <- argslist goes here
  (if (< year 4) false
      (if (zero? (mod year 4))
        (cond 
          (zero? (mod year 400)) true
          (zero? (mod year 100)) false
          :default true)
        false))
)
