(ns breaking-best-and-worst-records.core)

(defn breakingRecords [scores]
  (let [max-score (atom (first scores))
        min-score (atom (first scores))
        max-count (atom 0)
        min-count (atom 0)]
    (doseq [s scores]
      (cond
        (< s @min-score) (do
                           (reset! min-score s)
                           (swap! min-count inc))
        (> s @max-score) (do
                           (reset! max-score s)
                           (swap! max-count inc))))
    [@max-count @min-count]))

(def scores [10 5 20 20 4 5 2 25 1])
(= [2 4] (breakingRecords scores))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def scores (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (breakingRecords scores))

(spit fptr (clojure.string/join " " result) :append true)
(spit fptr "\n" :append true)
