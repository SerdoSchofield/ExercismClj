(ns spiral-matrix)

(defn get-grid [n]
  (vec (repeat n (vec (repeat n 0))))
)

(defn set-cell [grid row col val]
  (assoc grid
         row
         (assoc (nth grid row)
                col
                val)))

(defn spiral [n] ;; <- arglist goes here
  (loop [dir :right
         x 0
         y 0
         i 1
         lim-x n
         lim-y n
         ret (get-grid n)]
    ;(print dir :n n :x x :y y :i i :lim-x lim-x :lim-y lim-y ret (- n lim-x) (- n lim-y) \newline)
    (if (> i (* n n)) ret
        (case dir
          :right  (cond
                    (= y lim-y) (recur :down (inc x) (dec y) i lim-x lim-y ret)
                    :next (recur dir x (inc y) (inc i) lim-x lim-y (set-cell ret x y i)))
          :down   (cond
                    (= x lim-x) (recur :left (dec x) (dec y) i lim-x lim-y ret)
                    :next (recur dir (inc x) y (inc i) lim-x lim-y (set-cell ret x y i)))
          :left   (cond
                    (< y (- n lim-y)) (recur :up (dec x) (inc y) i (dec lim-x) lim-y ret)
                    :next (recur dir x (dec y) (inc i) lim-x lim-y (set-cell ret x y i)))
          :up     (cond
                    (< x (- n lim-x)) (recur :right (inc x) (inc y) i lim-x (dec lim-y) ret)
                    :next (recur dir (dec x) y (inc i) lim-x lim-y (set-cell ret x y i)))
          )
        )
    )
)
