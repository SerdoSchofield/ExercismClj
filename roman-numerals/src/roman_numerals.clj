(ns roman-numerals)

(def roman-num-map [
                    [1000 "M"]
                    [900 "CM"]
                    [500 "D"]
                    [400 "CD"]
                    [100 "C"]
                    [90 "XC"]
                    [50 "L"]
                    [40 "XL"]
                    [10 "X"]
                    [9 "IX"]
                    [5 "V"]
                    [4 "IV"]
                    [1 "I"]
                    ])

(defn numerals3 [n] ;; <- arglist goes here
  (let [i (apply str (repeat n "I"))
        v (clojure.string/replace i "IIIII" "V")
        x (clojure.string/replace v "VV" "X")
        l (clojure.string/replace x "XXXXX" "L")
        c (clojure.string/replace l "LL" "C")
        d (clojure.string/replace c "CCCCC" "D")
        m (clojure.string/replace d "DD" "M")
        cm (clojure.string/replace m "DCCCC" "CM")
        cd (clojure.string/replace cm "CCCC" "CD")
        xc (clojure.string/replace cd "LXXXX" "XC")
        xl (clojure.string/replace xc "XXXX" "XL")
        ix (clojure.string/replace xl "VIIII" "IX")
        iv (clojure.string/replace ix "IIII" "IV")]
    iv)
)

(defn numerals2 [n]
  (loop [i n
         digits roman-num-map
         ret ""]
    ;(print i digits)
    (if (empty? digits) ret
        (let [[k v] (first digits)]
          (if (< i k)
            (recur i (rest digits) ret)
            (recur (- i k) digits (str ret v))))))
)

(defmacro r [x y z] `(clojure.string/replace ~x ~y ~z))

(defn numerals [n]
  (r (r (r (r (r (r (r (r (r (r (r (r (apply str (repeat n "I"))
                                      "IIIII" "V")
                                   "VV" "X")
                                "XXXXX" "L")
                             "LL" "C")
                          "CCCCC" "D")
                       "DD" "M")
                    "DCCCC" "CM")
                 "CCCC" "CD")
              "LXXXX" "XC")
           "XXXX" "XL")
        "VIIII" "IX")
     "IIII" "IV"))
