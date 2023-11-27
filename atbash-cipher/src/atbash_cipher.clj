(ns atbash-cipher)

(defmacro cinc [c] `(char (inc (int ~c))))

(defmacro cdec [c] `(char (dec (int ~c))))

(defmacro >c [& cs]
  `(apply > (map int (list ~@cs))))

(defmacro <c [& cs]
  `(apply < (map int (list ~@cs))))

(defonce zero-to-nine
  (loop [i 0
         ret {}]
    (cond
      (> i 9) ret
      :else (recur (inc i) (assoc ret (first (str i)) i)))))

(defonce a-to-z
  (loop [i \a
         j \z
         ret zero-to-nine]
    (cond
      (>c i \z) ret
      :else  (recur (cinc i) (cdec j) (assoc ret i j)))))

(defn encode [s] ;; <- arglist goes here
  (loop [s (apply str (map a-to-z (seq (clojure.string/lower-case s))))
         i 0
         ret ""]
    (cond
      (empty? s) ret
      (> i 4) (recur s 0 (str ret " "))
      :else (recur (rest s) (inc i) (str ret (first s)))))
)
