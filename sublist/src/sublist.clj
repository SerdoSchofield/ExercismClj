(ns sublist)

(defn stringify [col]
  (apply str (mapcat #(str % \space) col)))

(defn classify [list1 list2] ;; <- arglist goes here
  (let [A (stringify list1)
        B (stringify list2)
        A-in-B (< -1 (.indexOf B A))
        B-in-A (< -1 (.indexOf A B))]
    (cond
      (and A-in-B B-in-A) :equal
      A-in-B :sublist
      B-in-A :superlist
      :default :unequal)))

