(ns etl)

(defn transform [source] ;; <- arglist goes here
  (loop [ret {}
         s source]
    (if (empty? s)
      ret
      (let [[key vals] (first s)]
        (recur
         (loop [ret2 ret
                v (set vals)]
           (if (not (empty? v))
             (recur
              (assoc ret2 (.toLowerCase (first v)) key)
              (next v))
             ret2))
         (next s)))))
)
