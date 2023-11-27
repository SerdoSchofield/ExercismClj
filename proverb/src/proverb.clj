(ns proverb)

(defn recite [words] ;; <- arglist goes here
  (let [word-groups (partition-all 2 1 words)]
    (if (empty? words)
      ""
      (apply str
             (reduce
              (fn [proverb [w1 w2]]
                (conj proverb
                      (case w2
                        nil (str "And all for the want of a "
                                 (first words)
                                 ".")
                        (str "For want of a "
                             w1
                             " the "
                             w2
                             " was lost.\n"))))
              [] word-groups)))))
