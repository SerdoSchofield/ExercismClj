(ns secret-handshake)

(def secrets {
              2r1 "wink"
              2r10 "double blink"
              2r100 "close your eyes"
              2r1000 "jump"
              })

(defn commands [n] ;; <- arglist goes here
  (let [message [(bit-and 2r1 n)
                 (bit-and 2r10 n)
                 (bit-and 2r100 n)
                 (bit-and 2r1000 n)]]
    (println message (bit-and 2r10000 n) (reverse message))
    (->>
     (if (zero? (bit-and 2r10000 n)) message (reverse message))
     (map secrets)
     (filter some?)))
)
