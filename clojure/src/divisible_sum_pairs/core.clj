(ns divisible-sum-pairs.core)


;; https://www.hackerrank.com/challenges/divisible-sum-pairs/problem

(defn combs [arr]
  (when (> (count arr) 1)
    (let [head  (first arr)
          tail  (rest arr)
          pairs (map (fn [a] [head a]) tail)]
      (concat pairs (combs tail)))))

(defn divisibleSumPairs [n k ar]
  (count (filter #(zero? (mod (+ (first %) (second %)) k)) (combs ar))))

(combs [1 3 2 6 1 2])
;; => ([1 3] [1 2] [1 6] [1 1] [1 2] [3 2] [3 6] [3 1] [3 2] [2 6] [2 1] [2 2] [6 1] [6 2] [1 2])

(= 5 (divisibleSumPairs 6 3 [1 3 2 6 1 2]))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def nk (clojure.string/split (read-line) #" "))

(def n (Integer/parseInt (clojure.string/trim (nth nk 0))))

(def k (Integer/parseInt (clojure.string/trim (nth nk 1))))

(def ar (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (divisibleSumPairs n k ar))

(spit fptr (str result "\n") :append true)
