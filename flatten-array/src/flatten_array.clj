(ns flatten-array)

(defn flatten [arr] ;; <- arglist goes here
  (filter (complement sequential?)
          (rest (tree-seq set? distinct [1 1 2 2 4 [4 3] 5]))))
  ;; (loop [ret []
  ;;        args arr]
  ;;   (if (empty? args)
  ;;     ret
  ;;     (let [arg (first args)]
  ;;       (if (coll? arg)
  ;;         (recur (vec (concat ret (flatten arg))) (next args))
  ;;         (recur (if (some? arg) (conj ret arg) ret) (next args)))))))
