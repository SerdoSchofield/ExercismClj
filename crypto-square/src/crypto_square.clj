(ns crypto-square)

(defn normalize-plaintext [s] ;; <- arglist goes here
  (let [lower (clojure.string/lower-case s)
        alpha-only (filter #(or (<= (int \0) (int %) (int \9)) (<= (int \a) (int %) (int \z))) lower)
        normalized (apply str alpha-only)]
    normalized)
)

(defn square-size-useful [n]
  (let [sqrt (Math/sqrt (count n))
        c (int (Math/floor sqrt))
        r (int (Math/ceil sqrt))]
    {:cols c :rows r})
)

(defn square-size [n] ;; <- arglist goes here
  (:rows (square-size-useful n))
)

(defn plaintext-segments [s] ;; <- arglist goes here
  (let [norm (normalize-plaintext s)
        col-num (:cols (square-size-useful norm))]
    (loop [s1 norm
           i 0
           ret ""]
      (cond
        (empty? s1) (clojure.string/split ret #"\s")
        (> i col-num) (recur s1 0 (str ret \space))
        :else (recur (rest s1) (inc i) (str ret (first s1))))))
)

(defn normalize-ciphertext [s] ;; <- arglist goes here
  (loop [segs (plaintext-segments s)
         ret []]
    (let [segs-1 (map first segs)]
      (if (empty? (filter not-empty segs)) (clojure.string/join \space ret)
          (recur (map rest segs) (conj ret (apply str segs-1)))
          )))
)

(defn ciphertext [s] ;; <- arglist goes here
  (apply str (clojure.string/split (normalize-ciphertext s) #"\s"))
)

