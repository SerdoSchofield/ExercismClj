(ns protein-translation)

(def codon-map {"Methionine" ["AUG"],
                "Phenylalanine" ["UUU" "UUC"],
                "Leucine" ["UUA" "UUG"],
                "Serine" ["UCU" "UCC" "UCA" "UCG"],
                "Tyrosine" ["UAU" "UAC"],
                "Cysteine" ["UGU" "UGC"],
                "Tryptophan" ["UGG"],
                "STOP" ["UAA" "UAG" "UGA"]})

(def protein-map
  (into {}
        (for [[k v] codon-map
              nucleotide v] [nucleotide k])))

(defn translate-codon [codon] ;; <- arglist goes here
  (protein-map codon)
)

(defn translate-rna [rna] ;; <- arglist goes here
 (take-while #(not (#{"STOP"} %))
              (for [nucleotides (partition 3 rna)
                    :let [codon (apply str nucleotides)]]
                (translate-codon codon)))
)
