(ns robot-name)

(def existing-robots (atom #{}))

(defn random-letter []
  (let [i (rand-int 26)]
    (char (+ (int \A) i))))

(defn gen-name 
  ([old-name]
   (if (contains? @existing-robots old-name)
     (swap! existing-robots disj old-name))
   (gen-name))
  ([]
   (loop [name ""]
     (cond
       (< (count name) 2) (recur (str name (random-letter)))
       (< (count name) 4) (recur (str name (format "%03d" (rand-int 1000))))
       (contains? @existing-robots name) (recur "")
       :default (do
                  (swap! existing-robots conj name)
                  name)))))

(defn robot [] ;; <- arglist goes here
  {:name (atom (gen-name))}
)

(defn robot-name [robot] ;; <- arglist goes here
  @(:name robot)
)

(defn reset-name [robot] ;; <- arglist goes here
  (swap! (:name robot) gen-name)
  robot
)
