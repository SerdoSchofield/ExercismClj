(ns triangle)

(defn is-valid? [s1 s2 s3] ;; <- arglist goes here
  (and
   (> (+ s1 s2) s3)
   (> (+ s1 s3) s2)
   (> (+ s2 s3) s1)
   )
)

(defn equilateral? [s1 s2 s3] ;; <- arglist goes here
  (and
   (is-valid? s1 s2 s3)
   (= s1 s2 s3))
)

(defn isosceles? [s1 s2 s3] ;; <- arglist goes here
  (and
   (is-valid? s1 s2 s3)
   (or
    (equilateral? s1 s2 s3)
    (= 2 (count (set [s1 s2 s3])))))
)

(defn scalene? [s1 s2 s3] ;; <- arglist goes here
  (and
   (is-valid? s1 s2 s3)
   (and
    (= 3 (count (set [s1 s2 s3])))
    (not (apply = [s1 s2 s3]))))
)
